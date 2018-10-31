package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * Form a subclass Collection2 from Collection and add a default method void
 forEachIf(Consumer<T> action, Predicate<T> filter) that applies action to each
 element for which filter returns true . How could you use it?

 */
public class Exercise9 {


    public interface Collection2<E> extends Collection<E> {
        default void forEachIf(Consumer<E> action, Predicate<E> filter) {
            forEach(e -> {
                if (filter.test(e)) {
                    action.accept(e);
                }
            });
        }
    }

    public static class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {}


    public static void main(String[] args) {
        ArrayList2<String> strings = new ArrayList2<>();

        strings.add("t");
        strings.add("xxss");
        strings.add("ggg");
        strings.add("qq");

        strings.forEachIf(System.out::println, s -> s.length() > 2);

    }


}
