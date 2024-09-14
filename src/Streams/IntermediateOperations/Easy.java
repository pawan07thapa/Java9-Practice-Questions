package Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Easy {
    public static void main(String[] args) {
        sortAlphabetically();

    }

    /*
     * Filter Even Numbers
     * Problem 1 : Given a list of integers, use a stream to filter out the even numbers.
     * Test Data: [1, 2, 3, 4, 5, 6]
     * Expected Output: [2, 4, 6]
     */
    public void filterEvenNumbers() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        //Approach I
        List<Integer> res = Arrays.stream(nums).filter(num -> num % 2 == 0).boxed().collect(Collectors.toList());
        //Approach II
        Arrays.stream(nums).filter(num -> num % 2 == 0).forEach(System.out::println);
    }

    /*
     * Convert to Uppercase
     * Problem 2: Given a list of strings, use a stream to convert all strings to uppercase.
     * Test Data: ["hello", "world"]
     * Expected Output: ["HELLO", "WORLD"]
     */
    public static void convertToUpperCase() {
        String[] los = {"hello", "world"};
        // Approach I
        Arrays.stream(los).map(String::toUpperCase).collect(Collectors.toList());

        //Approach II
        Arrays.stream(los).map(String::toUpperCase).forEach(System.out::println);

    }

    /*
     * Find Distinct Elements
     * Problem: Given a list of integers with duplicates, use a stream to get distinct elements.
     * Test Data: [1, 2, 2, 3, 4, 4, 5]
     * Expected Output: [1, 2, 3, 4, 5]
     */
    public void findDistinctElements() {
        Integer[] nums = {1, 2, 2, 3, 4, 4, 5};
        Arrays.stream(nums).distinct().forEach(System.out::println);
        Arrays.stream(nums).distinct().collect(Collectors.toList()).forEach(System.out::println);

        Arrays.asList(nums).stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

    }

    /*
     * Sort Strings Alphabetically
     * Problem: Given a list of strings, use a stream to sort them alphabetically.
     * Test Data: {"banana", "apple", "cherry"}
     * Expected Output: ["apple", "banana", "cherry"]
     */
    public static void sortAlphabetically() {
        String[] aos = {"banana", "apple", "cherry"};
        List<String> los = Arrays.asList(aos);

        Arrays.stream(aos).sorted().collect(Collectors.toList()).forEach(System.out::println);
        los.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    /*
     * Map to Square Values
     * Problem: Given a list of integers, use a stream to get a list of their squares.
     * Test Data: [1, 2, 3, 4]
     * Expected Output: [1, 4, 9, 16]
     */
    public static void mapToSquareValues() {
        Integer[] aoi = {1, 2, 3, 4};
        Arrays.stream(aoi).map(num -> num * num).collect(Collectors.toList()).forEach(System.out::println);

        Arrays.asList(aoi).stream().map(num -> num * num).collect(Collectors.toList()).forEach(System.out::println);
    }
}
