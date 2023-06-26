package section3.streamAPI;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        List<OnlineClass> spring = Arrays.asList(
                new OnlineClass(1, "spring boot", true),
                new OnlineClass(2, "spring data jpa", true),
                new OnlineClass(3, "spring mvc", false),
                new OnlineClass(4, "spring core", false),
                new OnlineClass(5, "rest", false)
        );

        System.out.println("start with spring");
        //Todo
        spring.stream().filter(s -> s.getTitle().startsWith("spring")).forEach(s -> System.out.println(s.getId() + " " + s.getTitle()));
        System.out.println("=============================");

        System.out.println("class not closed");
        //it would be better !OnlineClass:isClosed.. but can't add ! to method reference.
        //That's why we should use Predicate.not
        spring.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(s -> System.out.println(s.getId() + " " + s.getTitle()));
        //todo
        System.out.println("=============================");

        System.out.println("making a stream only class name");
        //todo
        spring.stream().map(OnlineClass::getId).forEach(System.out::println);
        System.out.println("=============================");

        List<OnlineClass> java = Arrays.asList(
                new OnlineClass(6, "java test", true),
                new OnlineClass(7, "java manipulation", true),
                new OnlineClass(8, "java 8", false)
        );

        List<List<OnlineClass>> Events = new ArrayList<>();
        Events.add(spring);
        Events.add(java);

        System.out.println("show all class names in Events.");
        //There are lists in a list.
        //we can see and access all elements by using flatMap.
        //List -> List.stream()   ---> releasing all in List.
        Events.stream()
                .flatMap(Collection::stream)
//                .flatMap(List -> List.stream())
                .forEach(oc -> System.out.println(oc.getId()));
        System.out.println("=============================");


        System.out.println("Output an unlimited stream of 10s in increments of 1, excluding the first 10.");
        Stream.iterate(10, i->i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("=============================");


        System.out.println("Check there is test class in Java classes");
        boolean test = java.stream().anyMatch(j -> j.getTitle().contains("test"));
        System.out.println(test);
        System.out.println("=============================");


        System.out.println("In spring classes, collect all the titles in your spring class that have spring in the title and make a list of them.");
        List<String> collect = spring.stream().map(OnlineClass::getTitle).filter(title -> title.contains("spring")).toList();
        System.out.println(collect);
        System.out.println("=============================");
    }

}
