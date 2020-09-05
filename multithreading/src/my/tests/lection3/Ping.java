package my.tests.lection3;

// Два потока делают пинг по очереди
// Вроде работает, проверить
public class Ping {

    static Object monitor = new Object();
    static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                   while (true) {
                        synchronized (monitor) {
                            while (flag) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("Thread1 ping " + System.currentTimeMillis());
                            flag = true;
                            monitor.notifyAll();
                        }
                    }
                }
            });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        while (!flag) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread2 ping " + System.currentTimeMillis());
                        flag = false;
                        monitor.notifyAll();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}
