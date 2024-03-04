package org.juandavid.thread.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor  executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        System.out.println("Tamaño del poll" + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea.. ");
            try {
                System.out.println("Nombre de thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea.....");

            return "¡Algún resultado importante de la tarea!";
        };

        Callable<Integer> tarea2 = ()->{
            System.out.println("Iniciando tareas 3 .....");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del poll " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando co nel método main ");

        //System.out.println(resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())) {
            System.out.println(String.format("resultado N°1 %s - resultado N°2 %s - resultado N°3: %s",
                    resultado.isDone()? "Finalizó" : "En Proceso",
                    resultado2.isDone()? "Finalizó" : "En proceso",
                    resultado3.isDone()? "Finalizó" : "En proceso"));
            TimeUnit.SECONDS.sleep(10);
        }
        System.out.println(resultado.get());
        System.out.println("Finalizando la tarea1 " + resultado.isDone());

        System.out.println(resultado.get());
        System.out.println("Finalizando la tarea2 " + resultado2.isDone());

        System.out.println(resultado.get());
        System.out.println("Finalizando la tarea3 " + resultado3.isDone());

    }
}
