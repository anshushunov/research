package my.tests.lection10;

import java.util.concurrent.atomic.AtomicInteger;

public class Lection10 {
    private static int index = 0;
    private static final Object mutex = new Object();

    // Программа может бесконечно печатать 0 или 1, т.к. jvm может пооптимизировать и отдавать лок всегда одному потоку
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        System.out.println("0");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        System.out.println("1");
                    }
                }
            }
        }).start();

    }
}
