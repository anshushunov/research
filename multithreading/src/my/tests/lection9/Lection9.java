package my.tests.lection9;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Lection9 {

    public static void aaa() {
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        Stream.iterate(0L, k -> k + 1)
                .parallel() // стрим можно сделать паралельным, можно через sequential - последовательным
                .filter(k -> k % 3 == 2)
                .limit(10)
                .forEach( k -> System.out.println(Thread.currentThread())); // Будут разные потоки в случае parallel/
        // parallel() stream - на самом деле просто API над Fork.Join Pool

        F myF = (a, b) -> a+b;
        System.out.println(myF);


        System.out.println("/////////////////////////////");

        Consumer<Long> consumer = System.out::println;

        Stream.iterate(0L, k -> k + 1)
                .filter(k -> k%3 == 2)
                .limit(10)
                .forEach(consumer);


        System.out.println("/////////////////////////////");

        new Thread(Lection9::aaa).start();

        System.out.println("/////////////////////////////");

        // java.util.function - ключевые функциональные интерфейсы явы

        Supplier<Double> s = Math::random;
        System.out.println(s.get());

        Function<String, Integer> f = Integer::valueOf;
        Predicate<Double> p = arg -> arg > 5;

        // filter : меняет кол-во, но НЕ меняет элем
        // map: НЕ меняет кол-во, но меняет элем
        // flatMap - меняет и тип и кол-вл

        Function<String, Stream<String>> ff = ss -> Stream.of(ss.split(" "));

        Arrays.asList("1", "22 333", "4444 55555")
                .stream()
                .flatMap(ff)
                .forEach(System.out::println);


        int sum = Stream.iterate(1, k -> k + 1)
                            .parallel()
                            .limit(10)
                            .reduce(0, (x, y) -> x + y);
    }
}

interface F {
    int add (int a, int b);
}
