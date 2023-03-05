import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Задание 2

        List<Integer> integers = List.of(1,2,3,4,5,6,8,89, 23, 56);
        checkNumber(integers);

        //Задание 1

        List<Student> studentList = new ArrayList<>();
        Stream<Integer> stream = integers.stream();

        findMinMax(stream, Integer::compareTo, (x,y) -> System.out.printf(x + "" + y));



    }

    public static<T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order)
                .collect(Collectors.toList());

        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }


    }

    public static void checkNumber(List<Integer> list) {
        long integers = list.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(integers);

    }
}