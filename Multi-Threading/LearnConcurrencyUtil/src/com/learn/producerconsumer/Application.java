package com.learn.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Application {
    public static void main(String[] args) {
        BlockingQueue<Integer> questionQueue=new ArrayBlockingQueue<Integer>(5);

        Thread t1=new Thread(new Consumer(questionQueue));
        Thread t2=new Thread(new Producer(questionQueue));

        t1.start();
        t2.start();
    }
}
