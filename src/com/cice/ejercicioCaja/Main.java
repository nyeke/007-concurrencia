package com.cice.ejercicioCaja;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int numCajas = 2;

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Cliente 1", new int[]{2,2,1,5,2})); // 12seg
        clientes.add(new Cliente("Cliente 2", new int[]{1,1,5,1,1})); //  9seg
        clientes.add(new Cliente("Cliente 3", new int[]{5,3,1,5,2})); // 16seg
        clientes.add(new Cliente("Cliente 4", new int[]{2,4,3,2,5})); // 16seg
        //clientes.add(new Cliente("Cliente 5", new int[]{1,3,2,2,3})); // 11seg
        //clientes.add(new Cliente("Cliente 6", new int[]{4,2,1,3,1})); // 11seg
        //clientes.add(new Cliente("Cliente 7", new int[]{3,3,2,4,7})); // 19seg
        //clientes.add(new Cliente("Cliente 8", new int[]{6,1,3,1,3})); // 14seg
        //tiempo total 53 segundos

        long init = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(numCajas);

        for(Cliente cliente : clientes){
            Runnable caja = new CajaRunnable(cliente,init);
            executor.execute(caja);
        }
        executor.shutdown();
        while (!executor.isTerminated()){
            //Espera para terminar los procesos antes de seguir
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de procesamiento " + (fin-init)/1000 + " segundos");
    }
}
