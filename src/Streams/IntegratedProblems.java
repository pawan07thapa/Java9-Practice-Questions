package Streams;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegratedProblems {

    public static void main(String[] args) {
//        stringByLength();
//        findFirstStartingWithChar('o');
//        sumOfSquaresOfOddNumber();
//        concatenateUppercasedString();
//        findMaxLengthByString();
//        averageOfDoubleList();
//        flatMapAndCollectInSet();
//        findStrEndingWithSuffix("er");
//        partitionByPalindroneString();
//        System.out.println(isPalindrome.apply("java"));
    }


    /**
     * Group Strings by Length
     * <p>
     * Problem: Given a list of strings, use a stream to group them by their lengths.
     * Test Data: String[] words = {"stream", "java", "api", "optional", "filter", "collect"}
     * Expected Output: {3=[api], 4=[java], 6=[stream, filter], 8=[optional]}
     */
    public static void stringByLength() {
        String[] words = {"stream", "java", "api", "optional", "filter", "collect"};
        Arrays.stream(words).collect(Collectors.groupingBy(String::length)).entrySet().stream().forEach((k) -> System.out.println("key : " + k.getKey() + ", val :" + k.getValue()));
    }


    /**
     * Find First String Starting with a Character
     * <p>
     * Problem: Given a list of strings, use a stream to find the first string starting with the letter 'o'.
     * Test Data: String[] words = {"orange", "apple", "olive", "banana", "octopus"}
     * Expected Output: Optional[orange]
     */
    public static void findFirstStartingWithChar(char ch) {
        String[] words = {"orange", "apple", "olive", "banana", "octopus"};
        System.out.println(Arrays.stream(words).filter(word -> word.charAt(0) == ch).findFirst());
    }

    /**
     * Sum of Squares of Odd Numbers
     * <p>
     * Problem: Given a list of integers, use a stream to compute the sum of squares of all odd numbers.
     * Test Data: int[] numbers = {1, 2, 3, 4, 5, 6}
     * Expected Output: 35
     */
    public static void sumOfSquaresOfOddNumber() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.stream(numbers).filter(n -> n % 2 != 0).map(n -> n * n).sum());
    }


    /**
     * Concatenate Uppercased Strings
     * <p>
     * Problem: Given a list of strings, use a stream to concatenate all strings in uppercase.
     * Test Data: String[] words = {"java", "stream", "optional"}
     * Expected Output: "JAVA STREAM OPTIONAL"
     */
    public static void concatenateUppercasedString() {
        String[] words = {"java", "stream", "optional"};
        System.out.println(Arrays.stream(words).map(w -> w.toUpperCase()).collect(Collectors.joining(" ")));
    }


    /**
     * Find Max by String Length
     * <p>
     * Problem: Given a list of strings, use a stream to find the longest string.
     * Test Data: String[] words = {"stream", "java", "api", "optional", "filter"}
     * Expected Output: Optional[optional]
     */
    public static void findMaxLengthByString() {
        String[] words = {"stream", "java", "api", "optional", "filter"};
        Arrays.stream(words).collect(Collectors.groupingBy(String::length)).entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey())).limit(1).forEach(k -> System.out.println("val :" + k));
    }


    /**
     * Calculate Average of Double List
     * <p>
     * Problem: Given a list of doubles, use a stream to compute the average.
     * Test Data: double[] numbers = {2.5, 3.0, 4.5, 5.0}
     * Expected Output: 3.75
     */
    public static void averageOfDoubleList() {
        double[] numbers = {2.5, 3.0, 4.5, 5.0};
        System.out.println(Arrays.stream(numbers).average().getAsDouble());
    }

    /**
     * Count Occurrences of a Character in Strings
     * <p>
     * Problem: Given a list of strings, use a stream to count the total number of occurrences of the character 'a'.
     * Test Data: String[] words = {"java", "banana", "apple", "avocado"}
     * Expected Output: 7
     */
//TODO again
    public static void countCharOccur() {
        String[] words = {"java", "banana", "apple", "avocado"};
//        System.out.println(Arrays.stream(words).spliterator());
    }

    /**
     * TODO
     * Flat Map and Collect to Set
     * <p>
     * Problem: Given a list of lists of strings, use a stream to flatten it into a single set of unique strings.
     * Test Data: List<List<String>> listOfLists = Arrays.asList(
     * Arrays.asList("java", "stream"),
     * Arrays.asList("api", "java"),
     * Arrays.asList("filter", "collect"));
     * Expected Output: [java, stream, api, filter, collect]
     */
    public static void flatMapAndCollectInSet() {
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("java", "stream"), Arrays.asList("api", "java"), Arrays.asList("filter", "collect"));

        System.out.println(listOfLists.stream().flatMap(Stream::of).collect(Collectors.toList()));
    }

    /**
     * Find Strings Ending with a Specific Suffix
     * <p>
     * Problem: Given a list of strings, use a stream to find all strings that end with 'er'.
     * Test Data: String[] words = {"runner", "water", "stream", "filter", "java"}
     * Expected Output: [runner, water, filter]
     */
    public static void findStrEndingWithSuffix(String suffix) {
        String[] words = {"runner", "water", "stream", "filter", "java"};
        System.out.println(Arrays.stream(words).filter(word -> word.endsWith(suffix)).collect(Collectors.toList()));
    }

    /**
     * Partition by Palindrome Strings
     * <p>
     * Problem: Given a list of strings, use a stream to partition them into palindromes and non-palindromes.
     * Test Data: String[] words = {"racecar", "java", "level", "stream", "rotor"}
     * Expected Output: {false=[java, stream], true=[racecar, level, rotor]}
     */

    public static void partitionByPalindroneString() {
        String[] words = {"racecar", "java", "level", "stream", "rotor"};
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(isPalindrome)));
    }

    public static void partitionByPalindroneStringInline() {
        String[] words = {"racecar", "java", "level", "stream", "rotor"};
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(s -> {
            for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) return false;
            }
            return true;
        })));
    }

    private static Function<String, Boolean> isPalindrome = s -> {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    };

}
