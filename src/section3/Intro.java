package section3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//stream is sequence of elements supporting sequential and parallel aggregate operations
//it is not collection having data.
//stream() don't change data
//You can also have unlimited data in a stream.
//Intermediate Methods of Stream are inherently lazy.
//Parallelization is easy.
//There are two types of operation
/*
* intermediate operations return String.
* terminal operations do not return String.
* */
public class Intro {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("he");
        name.add("she");
        name.add("tony");
        name.add("lily");
        name.add("who");

        // stream() don't change data
        List<String> collect = name.stream().map(s -> {
            //Before terminal operator like collect, nothing shows up.
            //After adding terminal operator, String shows up.
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("===============");

        name.forEach(System.out::println);

//parallel
        // is not always a good thing.
        // the amount of data.
        List<String> parallel = name.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        parallel.forEach(System.out::println);


    }

}
