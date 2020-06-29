package my.tests;

public class Test1 {

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        double d0 = 0;
        for (int k = 0; k < 100_000_000; k++) {
            d0 = d0 * d0;
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
        System.out.println(d0);
    }
}
