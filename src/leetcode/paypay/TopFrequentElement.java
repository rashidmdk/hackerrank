package leetcode.paypay;

import java.util.*;
import java.util.stream.IntStream;

public class TopFrequentElement {

    Comparator<Map.Entry<Integer, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1, 1, 1, 2, 2, 3, 1, 2, 3, 3, 3, 3};
        int k = 2;
        TopFrequentElement topFrequentElement = new TopFrequentElement();
        int[] frequentElements = topFrequentElement.getTopFrequentElement(nums, k);
        for (int frequentElement : frequentElements) {
            System.out.println(frequentElement);
        }
    }

    public int[] getTopFrequentElement(int[] nums, int k) {

        Map<Integer, Integer> counterMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> counterMap.put(num, counterMap.containsKey(num) ? counterMap.get(num) + 1 : 1));

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(counterMap.entrySet());
        entries.sort(comparator);

        return IntStream.range(0, k).map(i -> entries.get(i).getKey()).toArray();
    }
}
