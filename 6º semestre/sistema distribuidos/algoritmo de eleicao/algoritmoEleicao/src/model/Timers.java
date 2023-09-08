package model;

public enum Timers {

    ADICIONA(30000),
    REQUISICAO(25000),
    INATIVAR_COORDENADOR(100000),
    INATIVAR_PROCESSO(80000);

    private int desc;
    Timers(int i) {
        this.desc = i;
    }

    public int getTimer() {return this.desc;}
}
