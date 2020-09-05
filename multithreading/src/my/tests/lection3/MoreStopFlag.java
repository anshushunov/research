package my.tests.lection3;

public class MoreStopFlag {
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                run = false;
            }
        });
        thread.start();

        while (thread.isAlive()); //t t t f
        //thread.join(); // другой вариант, блокируем главный поток пока не завершится поток thread

        System.out.println(run); // гарантированно вернет false, потому что вызов isAlive() или join
        // устанавливает happens before, т.е. все значения из треда thread передадутся в основной поток

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
