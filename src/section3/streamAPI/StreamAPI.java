package section3.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPI {
    List<OnlineClass> spring =  Arrays.asList(
            new OnlineClass(1, "spring boot", true),
            new OnlineClass(2, "spring data jpa", true),
            new OnlineClass(3, "spring mvc", false),
            new OnlineClass(4, "spring core", false),
            new OnlineClass(5, "rest", false)
            );

    List<OnlineClass> java = Arrays.asList(
            new OnlineClass(6, "java test", true),
            new OnlineClass(7, "java manipulation", true),
            new OnlineClass(8, "java 8", false)
    );

}
