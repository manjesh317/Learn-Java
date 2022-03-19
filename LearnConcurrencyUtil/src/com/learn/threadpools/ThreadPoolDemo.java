package com.learn.threadpools;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(2);//recycle thread

        Runnable processor=new MessageProcessor(2);
        executor.execute(processor);

        Runnable processor2=new MessageProcessor(3);
        executor.execute(processor2);

        Runnable processor3=new MessageProcessor(4);
        executor.execute(processor3);

        Runnable processor4=new MessageProcessor(4);
        executor.execute(processor4);

        executor.shutdown();//reject any new tasks from being submitted. Gracefully shutdown the service
//        executor.shutdownNow();//Terminate the executor service immediately..

//        while (!executor.isTerminated()){ //wait until executor not shutdown and then execute the next statements
//
//        } or
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Submitted all task...");
    }
}
