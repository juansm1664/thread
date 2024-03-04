package org.juandavid.thread.Sync;

import com.sun.tools.jconsole.JConsoleContext;
import org.juandavid.thread.Sync.runnable.Consumidor;
import org.juandavid.thread.Sync.runnable.Panadero;

public class EjemploProductorConsumidor {

    public static void main(String[] args) {

        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
