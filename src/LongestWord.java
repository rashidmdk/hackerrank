import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;


public class LongestWord {

    public static void main(String[] args) {
        String str = "?This String $% Contains$$ punctuat !!";

        String result = Arrays.stream(str
                        .chars()
                        .filter(c -> Character.isLetter(c) || Character.isSpaceChar(c))
                        .mapToObj(value -> (char) value)
                        .collect(Collector.of(
                                StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::toString))
                        .split(" "))
                .max(Comparator.comparingInt(String::length)).orElse(null);

        System.out.println(result);
    }

}
