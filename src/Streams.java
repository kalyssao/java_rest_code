import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Used to process collections of objects using various methods - from collections but also from IO streams
// More efficient than iterating and helpful for large amounts of data
public class Streams {
    /*
    Stream Operations can be combined into pipelines to process data
    Intermediate operations can be chained (attached onto each other) eg. .map(x).filter(y)
    Terminal operations end the sequence (eg. collect)
    */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, -1, 7, 4, 5);

        // Ways to initialise a stream: https://www.geeksforgeeks.org/10-ways-to-create-a-stream-in-java/
        numbers.stream();
        Stream.of(numbers);

        // ForEach - terminal operation; does something to each element, returns nothing (we cannot collect)
        numbers.stream().forEach(n -> System.out.println(n));

        // Map - intermediate operation; applies a function to each element;
        List<Double> mappedNumbers = numbers.stream()
                                    .map(n -> Math.pow(n, 2.0))
                                    .collect(Collectors.toList());
        System.out.println("Mapped Numbers: " + mappedNumbers);

        // Filter - intermediate operation; retains elements based on a condition
        List<String> strings = Arrays.asList("apple", "watermelon", "aardvark", "yeti");
        List<String> filteredStrings = strings.stream()
                                        .filter(s -> s.startsWith("a"))
                                        .collect(Collectors.toList());
        System.out.println("Filtered Strings: " + filteredStrings);

        // Sorted - sorts
        List<String> sortedStrings = strings.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);
        System.out.println(sortedStrings);

        // FlatMap - flattens nested structures
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("Diana", "Prince")
                                        , Arrays.asList("Hermione", "Granger"), Arrays.asList("Annabeth", "Chase"));
        List<String> flattenedList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("Flattened List: " + flattenedList);

    }
}
