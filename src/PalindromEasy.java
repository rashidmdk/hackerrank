import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collector;

public class PalindromEasy {

    public static void main(String[] args) {
        String str = "never odd or even";
        str = str.replaceAll(" ", "");
        String reversed = new StringBuilder(str).reverse().toString();

        System.out.println(str.equals(reversed) ? true : false);
    }
}
