package com.learn.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue<Integer> questionQueue;

    public Consumer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
       while (true){
           try {
               Thread.sleep(1000);
               System.out.println("Answered question: "+questionQueue.take());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
