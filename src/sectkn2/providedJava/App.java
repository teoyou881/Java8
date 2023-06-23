package sectkn2.providedJava;

import java.util.*;

public class App {
    public static class Student {
        public Student() {
        }

        public Student(int num, String name, int cla) {
            this.num = num;
            this.name = name;
            this.cla = cla;
        }

        private int num;
        private String name;
        private int cla;

        public int getNum() {
            return num;
        }

        public String getName() {
            return name;
        }

        public int getCla() {
            return cla;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "num=" + num +
                    ", name='" + name + '\'' +
                    ", cla=" + cla +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(2, "Kim", 3),
                new Student(3, "Shin", 3),
                new Student(3, "Lee", 4),
                new Student(2, "Kang", 5),
                new Student(1, "Chul", 2),
                new Student(1, "Jang", 1),
                new Student(3, "Ahn", 2),
                new Student(1, "Hawng", 3),
                new Student(2, "Lim", 4)
        );

        List<String> name = new ArrayList<>();
        name.add("he");
        name.add("she");
        name.add("tony");
        name.add("lily");
        name.add("who");

//        for (String n : name) {
//            System.out.println(n);
//        }
        name.forEach(System.out::println);


        Spliterator<String> spliterator1 = name.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        //to allow balanced parallel computation and improve performance.
        //If the number of elements is odd like 5,
        //the number of elements returned is 2
        while (spliterator2.tryAdvance(System.out::println)) ;
        System.out.println("============================");
        while (spliterator1.tryAdvance(System.out::println)) ;


        long l = name.stream().map(String::toUpperCase).filter(s -> s.startsWith("L")).count();
        System.out.println(l);
        System.out.println("============================");

        name.removeIf(s -> s.startsWith("w"));
        name.forEach(System.out::println);
        System.out.println("============================");


        name.sort(String::compareToIgnoreCase);
        name.forEach(System.out::println);
        System.out.println("============================");

        Comparator<Student> comparingByName = Comparator.comparing(Student::getName);
        Comparator<Student> comparingByNum = Comparator.comparing(Student::getNum);
        //students.sort(Comparator.comparing(comparingByName).thenComparing(comparingByNum));
        students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getNum));
        students.forEach(System.out::println);
        System.out.println("============================");

        students.stream().sorted(comparingByName.thenComparing(comparingByNum)).forEach(System.out::println);
    }
}
