package Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Medium {


    public static void main(String[] args) {

//        findFirst();
//        countStringWithVowels();
        concatenateStrings();
    }

    /**
     * Filter Strings by Length
     * Problem: Given a list of strings, use a stream to filter strings with length greater than 3.
     * Test Data: ["one", "two", "three", "four"]
     * Expected Output: ["three", "four"]
     */
    public static void filterStringByLength() {
        String[] los = {"one", "two", "three", "four"};
        Arrays.stream(los).filter(str -> str.length() > 2).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * Problem: Given a list of integers, use a stream to find the first element that is greater than 10.
     * Test Data: [5, 8, 12, 15]
     * Expected Output: 12
     */
    public static void findFirst() {
        Integer[] aoi = {5, 8, 12, 15};
        Arrays.stream(aoi).filter(num -> num > 10).findFirst().ifPresent(System.out::println);
    }

    /**
     * Problem: Given a list of strings, use a stream to count the number of strings that contain at least one vowel.
     * Test Data: ["sky", "fly", "apple", "banana"]
     * Expected Output: 2
     * Sum of Odd Numbers
     */
    public static void countStringWithVowels() {
        String[] aos = {"sky", "fly", "apple", "banana"};
        System.out.println(Arrays.stream(aos).filter(str -> str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")).count());

        //Optimised
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        System.out.println(Arrays.stream(aos).filter(str -> str.chars().anyMatch(ch -> set.contains((char) ch))).count());
    }

    /**
     * Problem: Given a list of integers, use a stream to calculate the sum of all odd numbers.
     * Test Data: [1, 2, 3, 4, 5]
     * Expected Output: 9
     * Concatenate Strings
     */
    public static void sumOfOddNumbers() {
        List<Integer> loi = Arrays.asList(1, 2, 3, 4, 5);
        loi.stream().filter(num -> num % 2 != 0).collect(Collectors.summingInt(Integer::intValue));

        loi.stream().filter(num -> num % 2 != 0).reduce(0, (a, b) -> a + b);
    }

    /**
     * Concatenate Strings
     * <p>
     * Problem: Given a list of strings, use a stream to concatenate all the strings into one.
     * Test Data: ["Java", "is", "fun"]
     * Expected Output: "Javaisfun"
     */
    public static void concatenateStrings() {
        String[] str = {"Java", "is", "fun"};

        System.out.println(Arrays.stream(str).reduce("", (a, b) -> a + b));
        //Optimised
        Arrays.stream(str).collect(Collectors.joining());
    }

}
