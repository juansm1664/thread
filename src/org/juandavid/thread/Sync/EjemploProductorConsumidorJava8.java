package org.juandavid.thread.Sync;

import com.sun.source.tree.YieldTree;
import org.juandavid.thread.Sync.runnable.Consumidor;
import org.juandavid.thread.Sync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {

    public static void main(String[] args) {
        //Utilizando expresiones lambda y java 8
        Panaderia p = new Panaderia();

        new Thread( ()-> {
            for(int i= 0; i<10; i++){
                p.hornear(("Pan N°: "+ i));
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread( () -> {
            for(int i= 0; i<10; i++){
                p.consumir();
            }
        }).start();
    }
}
