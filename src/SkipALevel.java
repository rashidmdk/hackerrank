import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.ToLongFunction;
import java.util.stream.IntStream;

public class SkipALevel {

  public static void main(String[] args) {

    System.out.println("Collected Points: " + maximumPoints(15 , Arrays.asList(3, 2, 6, 4, 6, 1)));

  }

  public static int maximumPoints(int k, List<Integer> costs) {
    // Write your code here

    return Optional.of(k)
        .filter(points -> costs.stream().mapToLong(value -> value).sum() <= points)
        .map(points -> costs.size())
        .orElseGet(() -> {
          long maxValue = getMaxValue(costs);
          return IntStream.range(0, costs.size())
              .filter(operand -> getSum(costs, operand)-maxValue >= k).findFirst().orElse(costs.size()-1);
        });
  }

  private static long getSum(List<Integer> costs, int operand) {
    return costs.stream().mapToLong(value -> value).limit(operand+1).sum();
  }

  private static long getMaxValue(List<Integer> costs) {
    return costs.stream().mapToLong(value -> value).max().getAsLong();
  }


}
