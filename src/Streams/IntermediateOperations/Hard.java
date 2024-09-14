package Streams.IntermediateOperations;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hard {


    public static void main(String[] args) {

//        longestStringInList();
        partitionByEvenAndOdd();
    }

    /**
     * * Group By Length
     * <p>
     * Problem: Given a list of strings, use a stream to group them by their length.
     * Test Data: ["apple", "bat", "banana", "dog", "cat"]
     * Expected Output: {3=[bat, dog, cat], 5=[apple, banana]}
     */

    public static void groupByLength() {
        String[] los = {"apple", "bat", "banana", "dog", "cat"};
        System.out.println(Arrays.stream(los).collect(Collectors.groupingBy(str -> str.length())));
    }

    /**
     * FlatMap Example
     * Problem: Given a list of lists of integers, use a stream to flatten the lists and get a single list of integers.
     * Test Data: [[1, 2], [3, 4], [5]]
     * Expected Output: [1, 2, 3, 4, 5]
     * Average of Squares of Even Numbers
     */
    public static void flatMap() {
        int[][] aoa = {{1, 2}, {3, 4}, {5}};
        Arrays.stream(aoa).flatMap(array -> Stream.of(array)).collect(Collectors.toList());
        Arrays.stream(aoa).flatMap(Stream::of).collect(Collectors.toList());
    }

    /**
     * Average of Squares of Even Numbers
     * Problem: Given a list of integers, use a stream to calculate the average of the squares of even numbers.
     * Test Data: [1, 2, 3, 4, 5, 6]
     * Expected Output: 22.0
     */
    public static void avgOfSquaresOfEvenNumbers() {
        int[] arr = {1, 2, 3, 4, 5};

        Arrays.asList(1, 2, 3, 4, 5).stream().filter(num -> num % 2 == 0).map(num -> num * num).collect(Collectors.averagingInt(num -> num.intValue()));

        //Optimised
        Arrays.stream(arr).filter(num -> num % 2 == 0).boxed().collect(Collectors.averagingInt(n -> n*n));
        //OR
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(num -> num % 2 == 0).collect(Collectors.averagingInt(n -> n*n));
    }

    /**
     * Longest String in List
     *
     * Problem: Given a list of strings, use a stream to find the longest string.
     * Test Data: ["short", "medium", "longeststring"]
     * Expected Output: "longeststring"
     */
    public static void longestStringInList(){
        String [] los = {"short", "medium", "longeststring"};
        System.out.println(Arrays.asList(los).stream().reduce("", (a, b) -> a.length() > b.length()?a:b));
    }

    /**
     * Partition by Even and Odd
     *
     * Problem: Given a list of integers, use a stream to partition them into even and odd numbers.
     * Test Data: int [] aon= {1, 2, 3, 4, 5, 6}
     * Expected Output: {false=[1, 3, 5], true=[2, 4, 6]}
     */
    public static void partitionByEvenAndOdd(){
        int [] aon = {1,2,3,4,5,6};
        System.out.println( Arrays.stream(aon).boxed().collect(Collectors.groupingBy(num -> num % 2==0)));
    }
}
