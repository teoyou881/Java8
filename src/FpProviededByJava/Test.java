package FpProviededByJava;

import java.util.function.*;

public class Test {
    public static void main(String[] args) {

        Function<Integer, Integer> plus = i->i+5;
        Function<Integer, Integer> multi = i->i*31;

        System.out.println(plus.apply(10));

        System.out.println(plus.andThen(multi).apply(2));
        System.out.println(plus.compose(multi).apply(2));


        //no return
        Consumer<Integer> consumer = (i)-> System.out.println(i);
        consumer.accept(3);

        //no para
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());

        //return true or false
        Predicate<String> startsWithS = (s) ->s.startsWith("s");
        System.out.println(startsWithS.test("she"));
        System.out.println(startsWithS.test("he"));
        Predicate<Integer> isOdd = i ->i%2 !=0;
        System.out.println(isOdd.test(1));
        System.out.println(isOdd.test(2));

        //it's the same with Function interface, but it gets one more para.
        BiFunction<Integer,Integer,Integer> biFunction = (x,y)->{
          return x+y;
        };
        System.out.println(biFunction.apply(3,4));

        UnaryOperator<Integer> unaryOperator = (i)->i+3;
        System.out.println(unaryOperator.apply(3));
        BinaryOperator<Integer> binaryOperator = (x,y)->x+y;
        System.out.println(binaryOperator.apply(9,1));


    }
}
