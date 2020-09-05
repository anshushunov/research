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
                    System.out.println(data); // 1 в последний проход, потому что сделали
                    // запись и чтение В ТУ ЖЕ САМУЮ volatile перменную, т.е. она перекидывает
                    // весь контекст, в т.ч. запись в data
                }
            }
        }).start();
        Thread.sleep(10);
        data = 1;
        run = false;
        System.out.println("STOP");
    }
}
