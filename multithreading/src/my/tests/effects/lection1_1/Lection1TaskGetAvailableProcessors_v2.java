package my.tests.effects.lection1_1;

// Разные попытки, неудачно
public class Lection1TaskGetAvailableProcessors_v2 {
    public static void main(String[] args)
    {
        int a = 0;
        int b = 100000;

        int i = 0;
        while (i<8) {
            Thread tmpThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long currentTime = System.nanoTime();
                    findPrime(a, b);
                    long afterTime = System.nanoTime();
                    System.out.println(Thread.currentThread().getName() + " completed in " + (afterTime - currentTime));
                }
            });
            tmpThread.setName("Thread-"+i);
            tmpThread.start();
            //System.out.println(tmpThread.getName() + " started");
            i++;
        }
    }

    private static void findPrime(int a, int b) {
        // Declare the variables
        int i, j, flag;

        // Print display message
        //System.out.printf("\nPrime numbers between %d and %d are: ", a, b);

        // Traverse each number in the interval
        // with the help of for loop
        for (i = a; i <= b; i++) {

            // Skip 0 and 1 as they are
            // niether prime nor composite
            if (i == 1 || i == 0)
                continue;

            // flag variable to tell
            // if i is prime or not
            flag = 1;

            for (j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            // flag = 1 means i is prime
            // and flag = 0 means i is not prime
            if (flag == 1) {
                int x = 99 * flag;
                int y = x + 1;
            }
                //System.out.println(i);
        }
    }
}
