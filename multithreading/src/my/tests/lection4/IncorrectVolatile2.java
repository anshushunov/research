package my.tests.lection4;

public class IncorrectVolatile2 {

    public static volatile boolean f1 = false;
    public static volatile boolean f2 = false;
    public static volatile int counter = 0;

    // lost update
    private static void inc() {
        counter++;
    }

    // ++ не атомарная операция
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                    inc();
                }
                f1 = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                    inc();
                }
                f2 = true;
            }
        }).start();

        while (!f1 || !f2);

        System.out.println(counter);
    }
}

