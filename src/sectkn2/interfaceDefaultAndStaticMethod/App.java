package sectkn2.interfaceDefaultAndStaticMethod;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("whoru");
        foo.printName();
        foo.printNameUpperCase();
    }
}
