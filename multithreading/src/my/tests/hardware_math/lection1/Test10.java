package my.tests.hardware_math.lection1;

public class Test10 {
    public static void main(String[] args) {
        // Можно вычислить сколько модулей работы с даблами добавляя новые числа
        long t0 = System.currentTimeMillis();
        double d0 = 0;
        double d1 = 0;
        double d2 = 0;
        double d3 = 0;
        double d4 = 0;
        double d5 = 0;
        double d6 = 0;
        double d7 = 0;
        double d8 = 0;
        double d9 = 0;
        double d10 = 0;
        double d11 = 0;

        for (int k = 0; k < 100_000_000; k++) {
            d0 = d0 * d0;
            d1 = d1 * d1;
            d2 = d2 * d2;
            d3 = d3 * d3;
            d4 = d4 * d4;
            d5 = d5 * d5;
            d6 = d6 * d6;
            d7 = d7 * d7;
            d8 = d8 * d8;
            d9 = d9 * d9;
            d10 = d10 * d10;
            d11 = d11 * d11;
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - t0);
        System.out.println(d0);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);
        System.out.println(d8);
        System.out.println(d9);
        System.out.println(d10);
        System.out.println(d11);
    }
}
