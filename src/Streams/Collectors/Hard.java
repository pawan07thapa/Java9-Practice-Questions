package Streams.Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hard {

    public static void main(String[] args) {
//        groupWordsByFirstCharacterAndCount();
//        findLongestStringAfterGroupingByLength();
//        findTopElementsByFreq(2);
        sortItems();
    }

    /**
     * Group Words by First Character and Count
     * <p>
     * Problem: Given a list of strings, use a stream to group them by their first character and count the number of words in each group.
     * Test Data: String[] words = {"apple", "avocado", "banana", "cherry", "blueberry", "kiwi"}
     * Expected Output: {a=2, b=2, c=1, k=1}
     */
    public static void groupWordsByFirstCharacterAndCount() {
        String[] words = {"apple", "avocado", "banana", "cherry", "blueberry", "kiwi"};
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting())));
    }

    /**
     * Find the Longest String After Grouping by Length
     * <p>
     * Problem: Given a list of strings, use a stream to group them by their length and then find the longest string in each group.
     * Test Data: String[] words = {"apple", "banana", "pear", "kiwi", "watermelon"}
     * Expected Output: {5=apple, 6=banana, 4=kiwi, 10=watermelon}
     */
    public static void findLongestStringAfterGroupingByLength() {
        String[] words = {"apple", "banana", "pear", "kiwi", "watermelon"};
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(word -> word.length())).entrySet().stream().max((a, b) -> a.getKey().compareTo(b.getKey())));
    }

    /**
     * Calculate Total and Average Salary by Department
     * <p>
     * Problem: Given a list of employees with their department and salary, use a stream to calculate the total and average salary by department.
     * Test Data: Employee[] employees = {new Employee("John", "IT", 5000), new Employee("Jane", "HR", 6000), new Employee("Bob", "IT", 7000), new Employee("Alice", "HR", 5000)}
     * Expected Output: {IT={total=12000, average=6000}, HR={total=11000, average=5500}}
     */
    public static void totalAndAvgSalaryByDepartment() {

    }

    /**
     * Find the Top N Elements by Frequency
     * <p>
     * Problem: Given a list of integers, use a stream to find the top N most frequent elements.
     * Test Data: int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}
     * Expected Output for N=2: [4, 3]
     * System.out.println(Arrays.stream(nums).boxed().collect(Collectors.groupingBy( n -> n , Collectors.counting())).entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).limit(topN).map(e -> e.getKey()).collect(Collectors.toList()));
     */
    public static void findTopElementsByFreq(int topN) {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream().sorted((b, a) -> a.getValue().compareTo(b.getValue())).limit(2).map(e -> e.getKey()).collect(Collectors.toList()));
        ;
    }

    /**
     * Join Strings by Group and Reverse Order
     *
     * Problem: Given a list of strings, use a stream to group them by their first character, concatenate them in reverse order within each group, and output a Map.
     * Test Data: String[] words = {"apple", "avocado", "banana", "blueberry", "cherry", "citrus"}
     * Expected Output: {a=avocado, apple, b=blueberry, banana, c=citrus, cherry}
     */

    /**
     *         List<String> items =
     *                 Arrays.asList("apple", "apple", "banana",
     *                         "apple", "orange", "banana", "papaya");
     */

    public static void sortItems(){
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        System.out.println(items.stream().collect(Collectors.groupingBy( n -> n, Collectors.counting())).entrySet().stream().sorted((b,a) -> a.getValue().compareTo(b.getValue())).collect(Collectors.toList()));
    }
}
