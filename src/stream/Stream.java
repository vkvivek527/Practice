package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Stream {

    public static void main(String[] args){
        //Find the square of all even numbers.
        List<Integer> nums = List.of(3, 6, 9, 12, 15, 18);
        List<Integer> res = nums.stream().filter(a -> a % 2 == 0).map(a -> a*a).collect(toList());
        System.out.println(res);

        //Convert all names to uppercase and collect into a list.
        List<String> names = List.of("vivek", "rahul", "amit", "rohan");
        List<String> toUpperCase = names.stream().map(String::toUpperCase).toList();
        System.out.println(toUpperCase);

        // Count how many times "java" appears.
        List<String> words = List.of("java", "spring", "java", "boot", "java");
        long count = words.stream().filter(a -> a.equals("java")).count();
        System.out.println(count);

        //Sort in descending order.
        List<Integer> numbers = List.of(10, 5, 8, 20, 2);
        List<Integer> sorted = numbers.stream().sorted((a,b) -> b-a).toList();
        System.out.println(sorted);

       //Find the first even number.
        List<Integer> numslst = List.of(1, 3,4, 7, 8, 9);
        Optional<Integer> firstEven = numslst.stream().filter(a ->a%2 == 0).findFirst();
        System.out.println(firstEven.get());

       // Group By Length
        List<String> wordsLst = List.of("java", "spring", "boot", "microservices");
        Map<Integer, List<String>> groupRes = wordsLst.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupRes);

        //Create a frequency map.
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana","apple");
        Map<String,Integer> freqMap = items.stream().collect(Collectors.toMap(a -> a, a -> 1, Integer::sum));
        System.out.println(freqMap);

        String str = "aabbcbddfkfkm";
        char[] c = str.toCharArray();

        /* box char[] → Character[] */
        Character[] chArr = new Character[c.length];
        for (int i = 0; i < c.length; i++) {
            chArr[i] = c[i];
        }
        Map<Character, Long> freqMap1 =
                Arrays.asList(chArr)
                        .stream()
                        .collect(Collectors.groupingBy(
                                ch -> ch,
                                Collectors.counting()
                        ));

        /* print result */
        freqMap1.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}
