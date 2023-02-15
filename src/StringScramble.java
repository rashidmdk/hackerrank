import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;

public class StringScramble {
    public static void main(String[] args) {
        String str1 = "h3llko";
        String str2 = "hello";
        boolean stringScrambled = true;
        for (int i=0;i<str2.length();i++){
            char c = str2.charAt(i);
            if (str1.indexOf(c) != -1){
                str1 = str1.replace(String.valueOf(c), "");
            } else {
                stringScrambled = false;
                break;
            }
        }

        System.out.println(stringScrambled);
    }
}
