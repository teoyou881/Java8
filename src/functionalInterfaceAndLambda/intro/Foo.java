package functionalInterfaceAndLambda.intro;

public class Foo {
    public static void main(String[] args) {

        //anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("anonymous inner class");
            }
        };

        RunSomething runSomethingLambda = ()->{
            System.out.println("lambda");
        };

        runSomething.doIt();
        runSomethingLambda.doIt();

        /////////////////////////////////
        CalculateTest cal = (number -> {
            return number+10;
        });

        //always have to show the exact same value
        //when the same paras are inserted
        //must not refer to value or chane value outside of method
        System.out.println(cal.cal(10));




    }
}
