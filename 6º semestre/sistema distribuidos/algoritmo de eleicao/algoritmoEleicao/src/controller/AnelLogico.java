package controller;

import model.Processo;
import model.Timers;

import java.util.*;


public class AnelLogico {

    private static final ArrayList<Processo> processosAtivos = new ArrayList<>();
    private static boolean emVotacao = false;
    private Processo procAux;

    public AnelLogico() {
        init();
    }

    private void init() {
       novoProcesso().start();
       inativarProcesso().start();
       desativarCoordenador().start();
       efetuarRequisicao().start();
    }

    //crar um processo
    private Thread novoProcesso() {
       Thread aux;
       aux =  new Thread(() -> {
                while (true) {
                    if (!emVotacao) {
                        boolean coordenador;
                        Processo proc;
                        Processo anterior;

                        if(processosAtivos.isEmpty()) {
                            coordenador = true;
                            anterior = null;

                        } else {
                            coordenador = false;
                            anterior = processosAtivos.get(processosAtivos.size() - 1);
                        }

                        proc = new Processo(gerarIdProcesso(), coordenador, anterior, null);
                        setSucessor(proc);
                        processosAtivos.add(proc);

                        mostrarConsole(" == Criado novo processo id: " + proc.getCdProcesso() + " == ");
                    }

                    try {
                        Thread.sleep(Timers.ADICIONA.getTimer());

                    } catch (InterruptedException e) {
                        //caso de pau em dormir a thread ele para ela
                        System.err.println(" == ERRO AO BOTAR THREAD DE CRIAR PROCESSO PARA DORMIR");
                        Thread.interrupted();
                    }
                }
            });

       return aux;
    }

    private Thread inativarProcesso() {
        Thread aux;

        aux = new Thread( () -> {
           while (true) {
               if (!emVotacao) {
                   try {
                       Thread.sleep(Timers.INATIVAR_PROCESSO.getTimer());

                   } catch (InterruptedException e) {
                       //caso de pau em dormir a thread para ela
                       System.err.println(" == ERRO AO BOTAR THREAD DE INATIVAR PROCESSO PARA DORMIR");
                       Thread.interrupted();
                   }

                   procAux = pegarProcessoAtivoAleatorio();
                   ajustarVizinhos(processosAtivos.indexOf(procAux), procAux);
                   mostrarConsole(" ### REMOVENDO PROCESSO CD: " + procAux.getCdProcesso() + " ### ");
                   processosAtivos.remove(procAux.getCdProcesso());
               }
           }
        });

        return aux;
    }

    private Thread desativarCoordenador() {
        Thread aux;

        aux = new Thread(() -> {
            while (true) {
                if (!emVotacao) {
                    try {
                        Thread.sleep(Timers.INATIVAR_COORDENADOR.getTimer());

                    } catch (InterruptedException e) {
                        //caso de pau em dormir a thread para ela
                        System.err.println(" == ERRO AO BOTAR THREAD DE INATIVAR COORDENADOR PARA DORMIR");
                        Thread.interrupted();
                    }

                    procAux = retornaCoordenador();

                    System.out.println(" AAAAAAA - " + procAux);
                    if(procAux != null) {
                        ajustarVizinhos(processosAtivos.indexOf(procAux), procAux);
                        mostrarConsole(" !!! REMOVENDO COORDENADOR - CD: " + procAux.getCdProcesso() + "!!! ");
                        processosAtivos.remove(procAux);
                    }
                }
            }
        });

        return aux;
    }

    private Thread efetuarRequisicao() {
        Thread aux;

        aux = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(Timers.REQUISICAO.getTimer());
                } catch (InterruptedException e) {
                    //caso de pau em dormir a thread para ela
                    System.err.println(" == ERRO AO BOTAR THREAD DE EFETUAR REQUISIÇÃO PARA DORMIR");
                    Thread.interrupted();
                }

                procAux = pegarProcessoAtivoAleatorio();

                if(procAux != null) {

                System.out.println(" AAA - " + retornaCoordenador());
                    if(retornaCoordenador() != null) {
                        procAux.mandarRequisicao(Objects.requireNonNull(retornaCoordenador()));

                    } else {
                        isVotacao(true);
                        mostrarConsole(" @@@ ENTRANDO EM VOTAÇÃO @@@ ");

                        HashMap<Long, Processo> lista = new HashMap<>();
                        procAux.iniciarVotacao(lista);

                        long maior = 0;
                        for( Long l : lista.keySet()) {
                            if(l > maior) {
                                maior = l;
                            }
                        }

                        setCoordenador(maior);
                        isVotacao(false);

                        mostrarConsole(" @@@ FINALIZANDO VOTAÇÃO @@@ ");
                        mostrarConsole(" $$$ NOVO COORDENADOR - CD: " + maior + " $$$");
                    }
                }
            }
        });

        return aux;
    }

    //metodos auxiliares

    public static ArrayList<Processo> getProcessosAtivos() {
        return processosAtivos;
    }

    public static void mostrarConsole(String str) {
        System.out.println("--------------------------------------------------------");
        System.out.println(str);
        System.out.println("--------------------------------------------------------");
    }

    private void isVotacao(boolean votacao) {
        emVotacao = votacao;
    }

    private void setSucessor(Processo proc) {
        if(!processosAtivos.isEmpty()) {
            processosAtivos.get(processosAtivos.size() - 1).setSucessor(proc);
        }
    }

    private Long gerarIdProcesso() {
        Long num = new Random().nextLong(Long.MAX_VALUE);
        boolean igual = false;

        for (Processo proc : processosAtivos) {
            if(proc.getCdProcesso().equals(num)) {
                igual = true;
                break;
            }
        }

        if(igual) {
            num = gerarIdProcesso();
        }

        return num;
    }

    private void ajustarVizinhos(int index, Processo proc) {
        if (index >= 0 && index < processosAtivos.size() - 1) {
            processosAtivos.get(index + 1).setAntecessor(proc.getAntecessor());

            if(index > 0) {
                processosAtivos.get(index - 1).setSucessor(proc.getSucessor());
            }

        } else if(index == processosAtivos.size() - 1) {
             processosAtivos.get(index - 1).setSucessor(null);
        }
    }

    private Processo pegarProcessoAtivoAleatorio() {
        if (processosAtivos.size() < 2) {
            return null;
        }

        ArrayList<Processo> aux = new ArrayList<>(processosAtivos);
        Collections.shuffle(aux);

        Processo proc = aux.get(0);

        if(proc.isCoordenador()) {
            proc = pegarProcessoAtivoAleatorio();
        }

        return proc;
    }

    private Processo retornaCoordenador() {
        if(processosAtivos.isEmpty()) {
            return null;
        }

        Processo aux = null;

        for(Processo p : processosAtivos) {
            if(p.isCoordenador()) {
                aux = p;
                break;
            }
        }

        return aux;
    }

    private void setCoordenador(Long cd) {
        System.out.println("CD: " + cd);
        for(Processo proc : processosAtivos) {
            if(proc.getCdProcesso().equals(cd)) {
                proc.setIsCoordenador(true);
                break;
            }
        }

        for (Processo p : processosAtivos) {
            if (p.isCoordenador()) {
                System.out.println("CD: " + p.getCdProcesso() + " - aa:" + p.isCoordenador());
            }
        }
    }
}
