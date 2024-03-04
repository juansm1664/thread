package org.juandavid.thread.thread;

import org.juandavid.thread.thread.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Isla de pascua")).start();
        new Thread(new ViajeTarea("Robinson crusoe")).start();
        new Thread(new ViajeTarea("Juliana paris")).start();
        new Thread(new ViajeTarea("Isla de chiloe")).start();


    }
}
