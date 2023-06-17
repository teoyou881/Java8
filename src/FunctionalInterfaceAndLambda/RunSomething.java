package FunctionalInterfaceAndLambda;

//if an interface has only one abstract method, it is FP.
//it doesn't matter if it has another types of methods.

@FunctionalInterface
public interface RunSomething {

    void doIt();

    public static void printName(){
        System.out.println("static");
    }

    default void printAge(){
        System.out.println("89");
    }
}
