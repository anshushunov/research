package my.tests.lection9;

import java.util.stream.Stream;

public class Parallel {
    public static void main(String[] args) {

        Long start = System.nanoTime();
        int sum = Stream.iterate(1, k -> k + 1)
                //.parallel()
                .limit(1000)
                //должен быть ассоциативный оператор
                .reduce(0, (x, y) -> x + y);
        Long end = System.nanoTime();

        System.out.println(sum);
        System.out.println(end - start);

        //parallel:
        //73209900
        //63046100
        //64037400
        //58856700

        //non-parallel:
        //49025800
        //65886600
        //63581700

    }
}
