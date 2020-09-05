package my.tests.lection4;

public class IncorrectVolatile {

    public static volatile boolean f1 = false;
    public static volatile boolean f2 = false;
    public static volatile int counter = 0;

    // ++ не атомарная операция
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                    counter++;
                }
                f1 = true;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k < 10_000_000; k++) {
                    counter++;
                }
                f2 = true;
            }
        }).start();

        while (!f1 || !f2);

        System.out.println(counter);
    }
}
