package lambda;

import java.net.Inet4Address;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    private void run() {
        int baseNumber = 10; // effectively final

        //local class
        class LocalClass {
            int baseNumber = 1;

            public void print(Integer integer) {
                System.out.println("LocalClass  " + baseNumber);
            }
        }

        //anonymous class
        Consumer<Integer> con = new Consumer<Integer>() {
            int baseNumber = 2;

            @Override
            public void accept(Integer integer) {
                System.out.println("anonymous class  " + baseNumber);
            }
        };

        //lambda
        //Variable capturing is used in local, anonymous and lambda.
        //The different thing is shadowing.
        //lambda is not shadowing variable.
        //Because lambda's scope is the exact same with the thing surrounding lambda.
        IntConsumer printInt = (i) -> {
            //int baseNumber=3; error
            System.out.println("lambda  "  + baseNumber);
        };

        ///////////////////////////
        LocalClass lc = new LocalClass();
        lc.print(10);

        con.accept(10);

        printInt.accept(10);
    }
}
