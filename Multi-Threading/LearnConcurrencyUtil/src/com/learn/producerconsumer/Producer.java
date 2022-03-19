package com.learn.producerconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue<Integer> questionQueue;
    int questionNo;

    public Producer(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                synchronized (this){
                    int nextQuestion=questionNo++;
                    System.out.println("got new question: "+nextQuestion);
                    questionQueue.put(nextQuestion);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
