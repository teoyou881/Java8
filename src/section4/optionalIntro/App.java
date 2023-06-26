package section4.optionalIntro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> spring = Arrays.asList(
                new OnlineClass(1, "spring boot", true),
                new OnlineClass(2, "spring data jpa", true),
                new OnlineClass(3, "spring mvc", false),
                new OnlineClass(4, "spring core", false),
                new OnlineClass(5, "rest", false)
        );

        /*OnlineClass springTitle = new OnlineClass(1, "spring title", true);
        Duration studyDuration = springTitle.getProgress().getStudyDuration();
        System.out.println(studyDuration);*/
        //Cannot invoke "section4.Progress.getStudyDuration()" because the return value of "section4.OnlineClass.getProgress()" is null
        //1. people can make a mistake... even though we can check value is null or not...
        //2. returning null is just problem.

        //caution
        //Optional is strongly recommended to be used for return value. (not use it for method para, key type of map, field type of instance...)
        //in method returning Optional, do not return null.
        //There are also Optional for primitive types like OptionalInt, OptionalLong
        //Collection, Map, Stream Array, Optional don't be wrapped with Optional.

        OnlineClass springTitle = new OnlineClass(1, "spring title", true);
        Optional<Progress> studyDuration = springTitle.getProgress();

    }
}
