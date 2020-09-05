package my.tests.lection5;

/*
    java.util.cocurrent:
    - queue
    - collections
    - synchnozers
    - atomics
 */


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);

        // Producer
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while (true) {
                    try {
                        Thread.sleep(3000);
                        //блокируется если нет места в очереди
                        queue.put(++counter);
                        //кидает эксепшен если нет места
                        //queue.add(++counter);
                        //возвращает true если удалось, false если нет
                        //queue.offer(++counter);

                        System.out.println("put " + counter);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();

        // Consumer
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Integer data = 0;
                    try {
                        // Поток блокируется, можно избежать spin lock
                        data = queue.take();
                        // пришлось бы использовать спинлок, либо добавлять слип, но это полностью проблемы не решает
                        // можно использовать с таймаутом
                        //data = queue.poll(1, TimeUnit.SECONDS);
                        // тоже самое но кидает ошибку если нет элемента
                        // data = queue.remove();
                    } catch (InterruptedException e) {}
                    System.out.println("take: " + data);
                }
            }
        }).start();
        
        
    }

    private static void process(int data) {
    }
}
