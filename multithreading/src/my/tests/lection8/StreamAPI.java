package my.tests.lection8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        new Thread(StreamAPI::printHello).start();

        new Thread(() -> System.out.println("Hello")).start();

        List<String> stringList = Arrays.asList("A", "BB", "CCC");

        stringList.parallelStream()
                    .map(str -> str.length())
                    .filter(k -> k % 2 == 1)
                    .forEach(System.out::println);


        List<String> list = Arrays.asList("blue", "red");
        Optional<String> firstBlue = list.stream()
                .filter(s -> s.equals("green"))
                .findFirst();

        System.out.println(firstBlue);
        System.out.println(firstBlue.isPresent());

        // Бесконечный стрим, потом фильтруем, потом ограничиваем 10 записями
        Stream.iterate(0L, k -> k + 1)
                            .filter(k -> k%3 == 2)
                            .limit(10)
                            .forEach(k-> System.out.println(k ));



    }

    public static void printHello() {
        System.out.println("Hello!");
    }
}
