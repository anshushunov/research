package my.tests.effects.lection1_1;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Лонг занимает 8 байт. Если мы ставим v0 и v1 рядом то они оказываются на одной кеш линии(скорее всего).
    v1 и v8 точно на разных кеш линиях, поэтому в случае если во втором циксе умножать v1 то будет примерно ~ 4500ms
    а если заменить его на v8 то будет примерно ~700ms
 */

public class FalseSharingDetector {

    volatile static long v0 = 0;
    volatile static long v1 = 0;
    volatile static long v2 = 0;
    volatile static long v3 = 0;
    volatile static long v4 = 0;
    volatile static long v5 = 0;
    volatile static long v6 = 0;
    volatile static long v7 = 0;
    volatile static long v8 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        final CountDownLatch latch0 = new CountDownLatch(2);
        final CountDownLatch latch2 = new CountDownLatch(2);

        pool.submit(new Callable<Void>() {
            public Void call() throws Exception {
                latch0.countDown();
                latch0.await();
                long t0 = System.nanoTime();
                for (int k = 0; k < 100_000_000; k++) {
                    v0 = v0 * k;
                }
                long t1 = System.nanoTime();
                System.out.println((t1 - t0) / 1_000_000 + "ms");
                latch2.countDown();
                return null;
            }
        });

        pool.submit(new Callable<Void>() {
            public Void call() throws Exception {
                latch0.countDown();
                latch0.await();
                long t0 = System.nanoTime();
                for (int k = 0; k < 100_000_000; k++) {
                    v1 = v1 * k;
                }
                long t1 = System.nanoTime();
                System.out.println((t1 - t0) / 1_000_000 + "ms");
                latch2.countDown();
                return null;
            }
        });
        latch2.await();
        pool.shutdownNow();

    }
}
