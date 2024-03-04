package org.juandavid.thread.Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaPeriodo {
    public static void main(String[] args) {

        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            //private int contador = 3;

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(i > 0) {
                    System.out.println("Tarea periódica en: " + i + " " + new Date() +
                            ", Nombre del thread: " + Thread.currentThread().getName());
                    //contador--;
                } else {
                    System.out.println("finaliza el tiempo ");
                    timer.cancel();

                }

            }
        },5000, 10000);

        System.out.println("====== Agendamos una tarea para 5 minutos más..... ");

    }
}
