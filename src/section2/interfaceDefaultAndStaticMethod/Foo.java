package section2.interfaceDefaultAndStaticMethod;

public interface Foo {
    void printName();

    //Caution
    //just in case, if getName() return null, runtime exception occurs.
    //With at least effort, we need to document it thoroughly to avoid seeing errors.

    /*
    * @implSpec
    * The string got from getName change to Upper and print
    *
    * The implementation which implemented it can override.
    * Some method like equal, toString provided from Object can't override.
    *
    *
    * */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    String getName();


}
