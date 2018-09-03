package com.cice;

import com.cice.hilos.HiloPropio;

public class Main {

    public static void main(String[] args) {

        HiloPropio hilo = new HiloPropio();

        hilo.start();

        for(int i = 0; i<100; i++){
            System.out.println("Vuelta del main" + i);
        }
    }
}
