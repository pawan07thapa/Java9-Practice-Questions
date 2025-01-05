package Streams.Collectors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Medium {
    public static void main(String[] args) {
//        startsWithVowel();
//        groupIntegersByParityAndSum();
        findStringsWithMaxLength();
//        lengthOfWords();
    }
    /**
     * Partition by Starts With Vowel
     *
     * Problem: Given a list of strings, use a stream to partition them into those that start with a vowel and those that don't.
     * Test Data: String[] words = {"apple", "banana", "orange", "kiwi", "egg", "grape"}
     * Expected Output: {true=[apple, orange, egg], false=[banana, kiwi, grape]}
     */
    public static void startsWithVowel(){
        String[] words = {"apple", "banana", "orange", "kiwi", "egg", "grape"};
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        System.out.println("Vowels counting : "+Arrays.stream(words).collect(Collectors.groupingBy(word -> vowels.contains((char)word.charAt(0)))));
    }


    /**
     * Group Integers by Parity and Sum Them
     *
     * Problem: Given a list of integers, use a stream to group them by even and odd, and then compute the sum for each group.
     * Test Data: int[] nums = {1, 2, 3, 4, 5, 6}
     * Expected Output: {false=9, true=12}
     */
    public static void groupIntegersByParityAndSum(){
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println("Summing: "+Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n -> n%2 ==0, Collectors.summingInt(Integer::valueOf))));
        System.out.println("Counting : "+Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n -> n%2 ==0, Collectors.counting())));

    }

    /**
     * Find Strings with Maximum Length
     *
     * Problem: Given a list of strings, use a stream to find the strings with the maximum length.
     * Test Data: String[] words = {"apple", "banana", "pear", "kiwi", "watermelon"}
     * Expected Output: [watermelon]
     */
    public static void findStringsWithMaxLength() {
        String[] words = {"apple", "banana", "pear", "kiwi", "watermelon"};
        System.out.println(Arrays.stream(words).reduce("", (a, b) -> a.length() > b.length() ? a : b));

        Arrays.stream(words).collect(Collectors.groupingBy(String::length)).entrySet().stream().max((a,b) -> a.getKey().compareTo(b.getKey())).ifPresent(System.out::println);
    }

    /**
     * Calculate Average Length of Words
     *
     * Problem: Given a list of strings, use a stream to compute the average length of the words.
     * Test Data: String[] words = {"apple", "banana", "cherry", "date"}
     * Expected Output: 5.25
     */
    public static void lengthOfWords(){
        String[] words = {"apple", "banana", "cherry", "date"};
        System.out.println( Arrays.stream(words).collect(Collectors.groupingBy(word ->word.length())).keySet().stream().collect(Collectors.averagingDouble(Double::valueOf)));
        System.out.println(Arrays.stream(words).collect(Collectors.averagingInt(String::length)));
    }

    /**
     * Partition by Prime Numbers
     *
     * Problem: Given a list of integers, use a stream to partition them into prime and non-prime numbers.
     * Test Data: int[] nums = {2, 3, 4, 5, 6, 7, 8, 9, 10}
     * Expected Output: {true=[2, 3, 5, 7], false=[4, 6, 8, 9, 10]}
     */

}
