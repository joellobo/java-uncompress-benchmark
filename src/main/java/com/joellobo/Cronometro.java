package com.joellobo;

import org.apache.commons.lang.time.StopWatch;

/**
 * Cronometro para medir tempo de execucao.
 * @author SUPDE/DEFLA/DE305
 */
public class Cronometro {

    /**
     * Classe utilizada para medir o tempo de execucao.
     */
    private StopWatch stopWatch;

    /**
     * Construtor.
     */
    public Cronometro() {
        stopWatch = new StopWatch();
    }

    /**
     * Inicia a contagem do tempo.
     * @return Cronometro Cronometro
     */
    public Cronometro iniciar() {
        stopWatch.start();
        return this;
    }

    /**
     * Finaliza a contagem do tempo.
     * @return Cronometro Cronometro
     */
    public Cronometro finalizar() {
        stopWatch.stop();
        return this;
    }

    /**
     * Retorna o tempo de execucao.
     * @return tempo de execucao
     */
    public long getTempo() {
        return stopWatch.getTime();
    }

}
