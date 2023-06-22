package section1.methodReference;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Test {
    public static void main(String[] args) {
//        UnaryOperator<String> hii = (s) -> ("hi "+ s);
//        System.out.println(hii.apply("whoru"));
        //it's the same
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("whoru"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("whore"));

        //constructor
        Supplier<Greeting> supplier = Greeting::new;
        Greeting supplierGreeting = supplier.get();
        System.out.println(supplierGreeting.getName());


        //constructorTakingPara
        Function<String, Greeting> stringGreetingFunction = Greeting::new;
        Greeting str = stringGreetingFunction.apply("str");
        System.out.println(str.getName());

    }
}
