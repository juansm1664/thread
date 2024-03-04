package org.juandavid.thread;

import org.juandavid.thread.thread.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        Runnable viaje = () -> {

                for(int i=0; i<10; i++){
                    System.out.println( i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());

        };

        Thread v1= new Thread(viaje,"Isla de pascua"); //son asincronos, son paralelos
        Thread v2= new Thread(viaje,"Robinson crusoe");
        Thread v3= new Thread(viaje,"Juliana paris");
        Thread v4= new Thread(viaje, "Isla de chiloe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join(); //NO es estantico como el sleep
        v2.join();
        v3.join();

        System.out.println("continuando el método de ejecución del método main " + main.getName()) ;

        System.out.println(main.getState());

    }
}
