package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author yvan
 */
public class Crible {
    

    public static void main(String[] args) {
        /* int[] premier =IntStream.range(2, 100)
                .filter(p->p==2||p%2!=0)
                .filter(p->p==3||p%3!=0)
                .filter(p->p==5||p%5!=0)
                .filter(p->p==7||p%7!=0)
                .toArray();*/
         
         List<String> list = new ArrayList<>();
        list.add("C");
        list.add("H");
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("F");
        list.add("");

        list.parallelStream() // in parallel, not just concurrently!
            .filter(s -> !s.isEmpty()) // remove empty strings
            .distinct() // remove duplicates
            .sorted() // sort them
            .forEachOrdered(s -> System.out.println(s)); // print each item
         
         Random random = new Random();
         
         //random.ints(1, 10).limit(20).forEachOrdered(p->{System.out.print(p+" ");});
    }
}
