package my.tests.hardware_math.lection1;

public class Test2_2 {
    // занимает ~ столько же времени как умножение одного числа изза того что несколько модулей работы с даблами
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        double d0 = 0;
        double d1 = 0;
        for (int k = 0; k < 100_000_000; k++) {
            d0 = d0 * d0;
            d1 = d1 * d1;
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
        System.out.println(d0);
        System.out.println(d1);
    }
}
