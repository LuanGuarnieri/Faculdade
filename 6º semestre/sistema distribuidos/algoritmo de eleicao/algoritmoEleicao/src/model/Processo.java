package model;

import controller.AnelLogico;
import java.util.HashMap;

public class Processo {

    private final Long cdProcesso;
    private boolean isCoordenador;
    private Processo antecessor;
    private Processo sucessor;

    public Processo(Long cdProcesso, boolean isCoordenador, Processo anterior, Processo sucessor) {
        this.cdProcesso = cdProcesso;
        this.antecessor = anterior;
        this.sucessor = sucessor;
        setIsCoordenador(isCoordenador);
    }

    public void setIsCoordenador(boolean isCoordenador) {
        this.isCoordenador = isCoordenador;
    }

    public boolean isCoordenador() {
        return this.isCoordenador;
    }

    public Long getCdProcesso() {
        return this.cdProcesso;
    }

    public void setSucessor(Processo proc) {
        this.sucessor = proc;
    }

    public void setAntecessor(Processo proc) {
        this.antecessor = proc;
    }

    public Processo getAntecessor() {
        return this.antecessor;
    }

    public Processo getSucessor() {
        return this.sucessor;
    }

    public void receberRequisicao() {
        AnelLogico.mostrarConsole(" *** AINDA ESTOU VIVO CD: " + this.getCdProcesso() + " - SOU CORDENADOR: " + this.isCoordenador + " ***");
    }

    public void mandarRequisicao(Processo coordenador) {
        coordenador.receberRequisicao();
    }

    public void iniciarVotacao(HashMap<Long, Processo> lista) {
        if(lista.get(getCdProcesso()) == null) {
            lista.put(getCdProcesso(), this);

            if(getSucessor() != null) {
                getSucessor().iniciarVotacao(lista);

            } else {
                AnelLogico.getProcessosAtivos().get(0).iniciarVotacao(lista);
            }
        }
    }
}
