package com.furb.snmpProject.services.ping;

import com.furb.snmpProject.data.dto.HostDTO;
import com.furb.snmpProject.data.entities.Host;
import com.furb.snmpProject.data.enums.TipoOID;
import com.furb.snmpProject.data.repositories.HostRepository;
import com.furb.snmpProject.services.snmp.RequisicaoSNMP;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class IpRepos {

    public static boolean ping(String host) {
        try {
            return InetAddress.getByName(host).isReachable(3000);
        } catch (IOException e) {
            return false;
        }
    }
    public static int latenciaPing(String host) {
            long tempoInicial = System.nanoTime();
            long tempoFinal;

            if (ping(host)) {
                tempoFinal = System.nanoTime();
                return (int) ((tempoFinal - tempoInicial) / 1000000);
            } else {
                return -1;
            }
    }

    public static boolean validaIPV4(String ip) {
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        return ip.matches(ipv4Pattern);
    }

    public static String cadastraIP(String ip, HostRepository repos) {

        try {
            if (!validaIPV4(ip)) {
                return "IPV4 INVÁLIDO";
            }

            if (!ping(ip)) {
                return "HOST NÃO ENCONTRADO NA REDE";
            }

            Host host = new Host();
                 host.setIpHost(ip);
                 host.setDsHost(RequisicaoSNMP.requisicaoString(ip, TipoOID.NOME_HOST));

            repos.save(host);

            return "IPV4 CADASTRADO COM SUCESSO";

        } catch (Exception e) {
            return "HOUVE UM ERRO AO CADASTRAR O IPV4";
        }
    }

    public static List<HostDTO> retornaIPs(HostRepository repository) {
        List<Host> hosts = repository.findAll();
        List<HostDTO> ret = new ArrayList<>();

        for(Host host : hosts) {
            HostDTO aux = new HostDTO();
                    aux.setCdHost(host.getCdHost());
                    aux.setIpHost(host.getIpHost());
                    aux.setDsHost(host.getDsHost());
                    aux.setPingRede(ping(host.getIpHost()));
                    aux.setLatencia(latenciaPing(host.getIpHost()));

            ret.add(aux);
        }

        return ret;
    }
}
