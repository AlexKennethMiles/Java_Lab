package com.Miles.Lab_11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    //    static AtomicInteger totalSum = new AtomicInteger();
    static int totalSum;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i <  10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {

            System.out.println(t.getState());
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + ((endTime - startTime)/1000) + " sec");
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + ((endTime-startTime)/1000) + " sec");
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        lock.lock();
        for (int i = 0; i < count; i++) {
            a += (start + i) * Math.pow(start, count) * (start + i);
            incTotalSum();
        }
        lock.unlock();
        return a;
    }
    private synchronized static void incTotalSum()
    {
        totalSum++;
    }
}