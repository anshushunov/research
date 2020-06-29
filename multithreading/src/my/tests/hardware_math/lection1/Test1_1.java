package my.tests.hardware_math.lection1;

public class Test1_1 {
    // занимает х мс (127)
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
