package my.tests.lection11;


/*

 */

import java.util.OptionalInt;

import static java.util.stream.IntStream.of;


public class Lection11 {
    public static void main(String[] args) {
        // Редукция на моноине (ассоц операторе + нейтральный элем)
        Integer sum0 = of(1,2,3).reduce(0, (x,y) -> x+y);
        System.out.println(sum0);

        // МОНАДА: Optional / Just
        // Редукция на ассоц операторе
        OptionalInt sum1 = of(1,2,3).reduce((x, y) -> x + y);
        System.out.println(sum1.getAsInt());




    }
}
