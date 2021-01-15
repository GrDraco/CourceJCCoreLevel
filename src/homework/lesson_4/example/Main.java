package homework.lesson_4.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread_1 = new Thread(new MyThread());
        thread_1.setPriority(Thread.MIN_PRIORITY);
        thread_1.start();

        Thread thread_2 = new Thread(new MyThread_2());
        thread_1.setPriority(Thread.MAX_PRIORITY);
        thread_2.start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        thread_1.interrupt();
    }

    static class MyThread extends Thread {//implements Runnable {
        @Override
        public void run() {
            do {
                System.out.println("MyThread_1 started");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    return;
                }
            } while (!isInterrupted());
        }
    }

    static class MyThread_2 extends Thread {//implements Runnable {
        @Override
        public void run() {
            do {
                System.out.println("MyThread_2 started");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    return;
                }
            } while (!isInterrupted());
        }
    }
}
