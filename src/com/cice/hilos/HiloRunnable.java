package com.cice.hilos;

public class HiloRunnable implements Runnable {
    @Override
    public void run() {
        int ss = 0;
        int mm = 58;
        int hh = 0;

        do{
            System.out.println(hh + ":" + mm + ":" + ss);
            if (mm == 59 && ss == 59){
                ss=0;
                mm=0;
                hh+=1;
            } else {
                if (ss == 59) {
                    ss = 0;
                    mm += 1;
                } else {
                    ss += 1;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (hh<2);
    }
}
