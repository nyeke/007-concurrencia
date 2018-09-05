package com.cice;

import com.cice.hilos.HiloPropio;
import com.cice.hilos.HiloRunnable;

public class Main {

    public static void main(String[] args) {

        HiloRunnable hr = new HiloRunnable();
        Thread hilo = new Thread(hr);
        hilo.start();

//        HiloPropio hilo = new HiloPropio();
//
//        hilo.start();
//
//        for(int i = 0; i<100; i++){
//            System.out.println("Vuelta del main" + i);
//        }
    }
}
