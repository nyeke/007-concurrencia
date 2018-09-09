package com.cice.ejercicioCaja;

public class CajaRunnable implements Runnable{

    private Cliente cliente;
    private long initialTime;

    public CajaRunnable(Cliente cliente, long initialTime) {
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        System.out.println("La caja " + Thread.currentThread().getName()
                            + " comienza a procesar la compra del cliente " + this.cliente.getNombre()
                            + " en el tiempo: " + (System.currentTimeMillis() - this.initialTime)/ 1000
                            + "seg");
        for (int i = 0; i < this.cliente.getCarroCompra().length; i++){
            this.esperar(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) + " del " + this.cliente.getNombre()
                                + "-> Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
        }

        System.out.println("La caja " + Thread.currentThread().getName() + " ha TERMINADO de procesar "
                            + this.cliente.getNombre() + " en el TIEMPO: "
                            + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

    }

    private void esperar(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }
}
