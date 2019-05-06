package gz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String a = "this apple is sweet";
        String b = "this apple is sour";
        System.out.println("Input:\nA = " + a);
        System.out.println("B = " + b);

        System.out.println("Output: " + unique(a,b));
    }


    public static List<String> unique(String a, String b) {

        List<String> s = Arrays.stream((a + " " + b).split(" "))
                .sorted()
                .collect(Collectors.toList());

        List<String> sout = new ArrayList<>();

        if (!s.get(0).equals(s.get(1))) sout.add(s.get(0));

        IntStream.range(1, s.size() - 1)
                .filter(i -> !s.get(i).equals(s.get(i - 1)) && !s.get(i).equals(s.get(i + 1)))
                .mapToObj(s::get)
                .forEach(sout::add);

        if (!s.get(s.size() - 2).equals(s.get(s.size() - 1))) sout.add(s.get(s.size() - 1));

        return sout;

    }

}
