package org.juandavid.thread;

import org.juandavid.thread.thread.NombreThread;

public class EjemplosThread {
    public static void main(String[] args) {

        Thread hilo = new NombreThread("Pedro pascal");
        hilo.start(); //levanta el runnable

        Thread hilo2 = new NombreThread("sara");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("pepe");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
