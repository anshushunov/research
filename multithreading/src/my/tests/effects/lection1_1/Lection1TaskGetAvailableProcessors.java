package my.tests.effects.lection1_1;

// Задание к первой леции, определить кол-во процессоров
// Разные попытки, неудачно
public class Lection1TaskGetAvailableProcessors {
    // 1 -

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Processors = " + Runtime.getRuntime().availableProcessors());
        int i = 0;
        while (i<1) {
            Thread tmpThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long prevTime = System.nanoTime();
                    long max = 0;
                    while (true) {
                        long currentTime = System.nanoTime();
                        //System.out.println(Thread.currentThread().getName() + " " + (currentTime - prevTime));
                        if (max < currentTime - prevTime) {
                            max = currentTime - prevTime;
                            System.out.println(Thread.currentThread().getName() + " new max! Max = " + max);
                        }
                        prevTime = currentTime;
                    }
                }
            });
            tmpThread.setName("Thread-"+i);
            tmpThread.start();
            System.out.println(tmpThread.getName() + " started");
            i++;
        }
    }
}
