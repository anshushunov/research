package my.tests.lection10;

import java.util.concurrent.locks.ReentrantLock;

public class Lection10_1 {
    private static int index = 0;
    private static final ReentrantLock lock = new ReentrantLock(true);

    // Может быть последовательность, но бесконечной последовательности быть не может
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println("0");
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    System.out.println("1");
                    lock.unlock();
                }
            }
        }).start();
    }
}
