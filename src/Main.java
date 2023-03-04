import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        //Задание 1

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Рамиль", 18, 1));
        studentList.add(new Student("Василий", 19, 2));
        studentList.add(new Student("Марина", 20, 3));
        studentList.add(new Student("Евгений", 21, 4));
        studentList.add(new Student("Александр", 20, 3));
        studentList.add(new Student("Елена", 19, 2));

        findMinMax(studentList);

        //Задание 2

        List<Integer> integers = List.of(1,2,3,4,5,6,8,89, 23, 56);
        checkNumber(integers);

    }

    public static void findMinMax(List<Student> studentList) {
        String minValue = studentList.stream()
                .min(Comparator.comparing(Student::getCourse))
                .map(Student::getName).get();

      String maxValue = studentList.stream()
                .max(Comparator.comparing(Student::getCourse))
                .map(Student::getName).get();

        BiConsumer<String, String> minMaxConsumer = (a, b) -> System.out.println("Самый взрослый студент " + a + ", самый взрослый студент- " + b);

        if (minMaxConsumer == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(minValue, maxValue);
        }


    }

    public static void checkNumber(List<Integer> list) {
        long integers = list.stream()
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println(integers);

    }
}