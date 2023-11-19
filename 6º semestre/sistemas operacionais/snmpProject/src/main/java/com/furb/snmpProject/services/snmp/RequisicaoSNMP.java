package com.furb.snmpProject.services.snmp;

import com.furb.snmpProject.data.enums.TipoOID;
import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

import java.io.IOException;
import java.util.List;

public class RequisicaoSNMP {

    public static void main(String[] args) throws Exception {
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public")); // Substitua pela sua comunidade SNMP
        target.setVersion(SnmpConstants.version2c);
        target.setAddress(new UdpAddress("192.168.1.10/161")); // Substitua pelo endereço e porta do seu agente SNMP
        target.setRetries(2);
        target.setTimeout(1500);

        TransportMapping<? extends Address> transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();

        TableUtils tableUtils = new TableUtils(snmp, new DefaultPDUFactory());
        OID[] columns = new OID[] { new OID("1.3.6.1.2.1.25.4.2.1.2") }; // OID da coluna de nomes de processos

        List<TableEvent> events =requisicaoTabela("192.168.1.10", TipoOID.LISTA_PROCESSOS);
        if (events != null && !events.isEmpty()) {
            for (TableEvent event : events) {
                VariableBinding[] vb = event.getColumns();
                if (vb != null) {
                    for (VariableBinding variable : vb) {
                        System.out.println(variable.getVariable().toString());
                    }
                }
            }
        } else {
            System.out.println("Não foi possível obter a tabela de processos.");
        }

        snmp.close();

    }


    private static final String COMUNIDADE = "public";
    private static final int PORT = 161;

    //EFETUA REQUISIÇÃO DE UMA STRING
    public static String requisicaoString(String ipAddress, TipoOID oid) throws Exception {
        PDU pdu = createGetPDU(oid.getOID());
        Snmp snmp = createSnmpSession();
        CommunityTarget target = createCommunityTarget(ipAddress);
        ResponseEvent response = sendSnmpRequest(snmp, pdu, target);

        return extractResponseValue(response);
    }

    public static  List<TableEvent> requisicaoTabela(String ipAddress, TipoOID oid) throws Exception {
        Snmp snmp = createSnmpSession();
        CommunityTarget target = createCommunityTarget(ipAddress);
        TableUtils tableUtils = new TableUtils(snmp, new DefaultPDUFactory());
        OID[] columns = {new OID(oid.getOID())};

        List<TableEvent> tableEvents = tableUtils.getTable(target, columns, null, null);

        return tableEvents;
    }

    private static Snmp createSnmpSession() throws IOException {
        TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        return snmp;
    }

    private static CommunityTarget createCommunityTarget(String ipAddress) {
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(COMUNIDADE));
        target.setAddress(new UdpAddress(ipAddress + "/" + PORT));
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        return target;
    }

    private static PDU createGetPDU(String oid) {
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(oid)));
        pdu.setType(PDU.GET);
        return pdu;
    }

    private static ResponseEvent sendSnmpRequest(Snmp snmp, PDU pdu, CommunityTarget target) throws IOException {
        return snmp.send(pdu, target, null);
    }

    private static String extractResponseValue(ResponseEvent response) {
        if (response != null) {
            PDU responsePDU = response.getResponse();
            if (responsePDU != null) {
                VariableBinding vb = responsePDU.get(0);
                if (vb != null) {
                    Variable var = vb.getVariable();
                    return var.toString();
                }
            }
        }
        return null;
    }


}
