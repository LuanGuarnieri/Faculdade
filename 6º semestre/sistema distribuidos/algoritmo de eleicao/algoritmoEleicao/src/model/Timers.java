package model;

public enum Timers {

    ADICIONA(10000), // 30000
    REQUISICAO(12500), // 25000
    INATIVAR_COORDENADOR(35000), //100000
    INATIVAR_PROCESSO(25000); // 80000

    private int desc;
    Timers(int i) {
        this.desc = i;
    }

    public int getTimer() {return this.desc;}
}
