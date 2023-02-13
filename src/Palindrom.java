import java.util.Arrays;
import java.util.List;

public class Palindrom {

    public static void main(String args[]) {
        String s = "cbac";
        List<Integer> startIndex = Arrays.asList(0, 2, 1);
        List<Integer> endIndex = Arrays.asList(3, 3, 3);
        List<Integer> subs = Arrays.asList(0, 2, 2);
        System.out.println(palindromeChecker(s, startIndex, endIndex, subs));
    }

    public static String palindromeChecker(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        int[][] queries = new int[startIndex.size()][3];
        for (int i = 0; i < startIndex.size(); i++) {
            queries[i][0] = startIndex.get(i);
            queries[i][1] = endIndex.get(i);
            queries[i][2] = subs.get(i);
        }

        int n = s.length();
        int[][] prefixCount = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            prefixCount[i + 1] = prefixCount[i].clone();
            prefixCount[i + 1][s.charAt(i) - 'a']++;
        }
        String res = "";
        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];
            int k = q[2];
            int count = 0;
            for (int i = 0; i < 26; i++) {
                count += (prefixCount[end + 1][i] - prefixCount[start][i]) % 2;
            }
            res = res + (count / 2 <= k ? "1" : "0");
        }

        return res;
    }
}
