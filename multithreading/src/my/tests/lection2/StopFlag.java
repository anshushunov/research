package my.tests.lection2;

public class StopFlag {
    static volatile boolean run = true;
    static int data = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    System.out.println("hello");
                    System.out.println(data); // 1!!!
                }
            }
        }).start();
        Thread.sleep(10);
        data = 1;
        run = false;
        System.out.println("STOP");
    }
}
