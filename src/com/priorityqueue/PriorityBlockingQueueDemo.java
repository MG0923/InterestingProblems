package com.priorityqueue;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueDemo {

    public static void priorityBlockingQueue() {
        Queue<Integer> pbq
                = new java.util.concurrent.PriorityBlockingQueue<>();

        pbq.add(10);
        pbq.add(20);
        pbq.add(15);

        System.out.println(pbq);

        System.out.println(pbq.peek());

        System.out.println(pbq.poll());

        System.out.println(pbq);

        System.out.println(pbq.peek());
    }

    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.PriorityBlockingQueue<Integer> queue = new java.util.concurrent.PriorityBlockingQueue<>();
        Thread thread = new Thread(() -> {
            System.out.println("Polling...");
            while (true) {
                try {
                    Integer poll = queue.take();
                    System.out.println("Polled: " + poll);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        System.out.println("Adding to queue");

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        queue.addAll(Arrays.asList(1, 5, 6, 1, 2, 6, 7));
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        priorityBlockingQueue();
    }
}
