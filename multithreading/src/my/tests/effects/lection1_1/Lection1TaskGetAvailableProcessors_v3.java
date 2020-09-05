package my.tests.effects.lection1_1;

//TODO дописать чтобы несколько тредов
// Разные попытки, неудачно
public class Lection1TaskGetAvailableProcessors_v3 extends Thread {
    public long longMax;
    public long primeMax;
    public long primeCount;
    public long jobCount;
    public static void main(String[] args) {
        long max = 1000;
        long interval = 1;
        Lection1TaskGetAvailableProcessors_v3 t = new Lection1TaskGetAvailableProcessors_v3();
        t.start();
        int i = 0;
        long startTime = System.currentTimeMillis();
        System.out.println("Time, Count, Productivity, PrimeCount, PrimeMax");
        while (true) {
            try {
                sleep(interval*1000);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
            long curTime = System.currentTimeMillis();
            long duration = (curTime - startTime)/1000;
            long productivity = t.jobCount/duration;
            System.out.println(duration+", "+t.jobCount+", "+productivity+", "+t.primeCount+", "+t.primeMax);
        }
    }

    public  Lection1TaskGetAvailableProcessors_v3() {
        longMax = 1000;
        primeCount = 0;
        primeMax = 0;
    }

    public  void run(){
        jobCount = 0;
        while (true) {
            long count = 0;
            long max = 0;
            for (long i=3; i<longMax; i++) {
                boolean isPrime = true;
                for (long j=2; j <= i/2 && isPrime; j++) {
                    isPrime = i % j > 0;
                }
                if (isPrime) {
                    count++;
                    max = i;
                }
            }
            primeCount = count;
            primeMax = max;
            jobCount++;
        }
    }
}
