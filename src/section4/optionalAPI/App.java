package section4.optionalAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> spring = new ArrayList<>();

        spring.add(new OnlineClass(1, "spring boot", true));
        spring.add(new OnlineClass(2, "spring data jpa", true));
        spring.add(new OnlineClass(3, "spring mvc", false));
        spring.add(new OnlineClass(4, "spring core", false));
        spring.add(new OnlineClass(5, "rest", false));


        Optional<OnlineClass> first = spring.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .findFirst();

        //it is recommended to use several useful Optional method instead of get().
        //to use get(), have to check Optional has element.
        //But, it is easier for us that use another methods in context...
        if (first.isPresent()) {
            System.out.println("first = " + first.get().getTitle());
        } else {
            System.out.println("first = " + "is empty");
        }


        //do something with element in Optional
        first.ifPresent(s-> System.out.println(s.getTitle()));

    }
}
