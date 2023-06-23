package section2.interfaceDefaultAndStaticMethod;

public interface Poo extends Foo {

    //in Foo interface, the method below is default.
    //But here, we can redeclare it as abstract method.
    void printNameUpperCase();
}
