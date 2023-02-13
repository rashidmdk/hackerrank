import java.util.*;

public class ClosestNumbers {

    public static void main(String args[]) {
        closestNumbers(Arrays.asList(4,-2,-1,3));
    }

    public static void closestNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<Integer>();
        Collections.sort(numbers);
        int mindist = Integer.MAX_VALUE;
        Set<Integer> indexes = new HashSet<Integer>();
        int currdist;

        for (int i = 0; i < numbers.size() - 1; i++) {
            currdist = numbers.get(i + 1) - numbers.get(i);
            if (currdist < mindist) {
                indexes = new HashSet<Integer>();
                indexes.add(i);
                mindist = currdist;
            }
            if (currdist == mindist) {
                indexes.add(i);
            }
        }

        Iterator<Integer> it = indexes.iterator();
        int next;
        while (it.hasNext()) {
            next = it.next();
            result.add(numbers.get(next));
            result.add(numbers.get(next + 1));
        }

        Collections.sort(result);
        int k = 0;
        while (k < result.size()) {
            System.out.println(result.get(k) + " " + result.get(k + 1));
            k += 2;
        }
    }
}
