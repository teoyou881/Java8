package section4.optionalAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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

        //if there is nothing, return other.
        OnlineClass orElse = first.orElse(createNewClass()); // 인자로 넘겨주는 것이기 때문에 createNewClass() 코드는 무조건 실행
        OnlineClass orElseGet = first.orElseGet(() -> createNewClass()); // 값이 있다면? --> createNewClass() 실행하지 않음.

        //if there is nothing, throw something.
        first.orElseThrow(()->{
            return new IllegalArgumentException();
        });
        OnlineClass orElseThrow = first.orElseThrow(IllegalAccessError::new);

        //optional filter
        Optional<OnlineClass> filter = first.filter(OnlineClass::isClosed);
        System.out.println("filter.isPresent() = " + filter.isPresent());
        
        //optional map
        //The type converted by map is returned.
        Optional<Integer> map = first.map(s -> s.getId());
        System.out.println("map.get()= " + map.get());

        //what if optional in optional?
        //it is too long and unuseful
        /*Optional<Optional<Progress>> progress = first.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        progress1.orElseThrow();*/
        //flatmap in Optional
        Optional<Progress> progress = first.flatMap(OnlineClass::getProgress);
        Progress progress1 = progress.orElseGet(Progress::new);
        System.out.println("progress1 = " + progress1);


    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "new class", true);
    }
}
