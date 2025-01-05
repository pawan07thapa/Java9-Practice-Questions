package Streams.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Easy {
    public static void main(String[] args) {

//        countEvenAndOddNumbers();
//        sumOfSquaredIntegers();
        findMaxInteger();
    }

    /**
     * Count Even and Odd Numbers
     *
     * Problem: Given a list of integers, use a stream to count the number of even and odd numbers.
     * Test Data: int[] nums = {1, 2, 3, 4, 5, 6}
     * Expected Output: {false=3, true=3}
     */

    public static void countEvenAndOddNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        List<Integer> loi = Arrays.stream(nums).boxed().collect(Collectors.toList());
        loi.stream().collect(Collectors.groupingBy(n -> n%2 ==0)).forEach((k,v) -> System.out.println(k + " " + v.size()));
    }

    /**
     * Group Strings by Length
     *
     * Problem: Given a list of strings, use a stream to group them by their length.
     * Test Data: String[] words = {"apple", "pear", "banana", "kiwi", "cherry"}
     * Expected Output: {5=[apple, cherry], 4=[pear, kiwi], 6=[banana]}
     */

    public static void groupStringsByLength() {
        String[] words = {"apple", "pear", "banana", "kiwi", "cherry"};
        Arrays.stream(words).collect(Collectors.groupingBy(str -> str.length())).forEach((k,v) -> System.out.println(k + " " + v));
    }

    /**
     * Sum of Squared Integers
     *
     * Problem: Given a list of integers, use a stream to compute the sum of their squares.
     * Test Data: int[] nums = {1, 2, 3, 4}
     * Expected Output: 30
     */
    public static void sumOfSquaredIntegers() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.stream(nums).map(n -> n*n ).sum());
        System.out.println(Arrays.stream(nums).map(n -> n*n ).reduce(0, Integer::sum));
    }

    /**
     * Concatenate Strings with Delimiter
     *
     * Problem: Given a list of strings, use a stream to concatenate them separated by a comma.
     * Test Data: String[] fruits = {"apple", "banana", "cherry"}
     * Expected Output: "apple,banana,cherry"
     */

    public static void concatenateStringsWithDelimiter() {
        String[] fruits = {"apple", "banana", "cherry"};
        System.out.println(Arrays.stream(fruits).collect(Collectors.joining(",")));
    }
    /**
     * Find Maximum Integer
     *
     * Problem: Given a list of integers, use a stream to find the maximum value.
     * Test Data: int[] nums = {5, 3, 8, 2, 9}
     * Expected Output: 9
     */
    public static void findMaxInteger(){
        int[] nums = {5, 3, 8, 2, 9};
        System.out.println(Arrays.stream(nums).max());
        System.out.println(Arrays.asList(5,3,8,2,9).stream().max((a,b) -> a.compareTo(b)));

    }

}
