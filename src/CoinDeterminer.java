import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinDeterminer {

    public static void main(String[] args) {
        int num = 34;
        final List<Integer> coins = Arrays.asList(1, 5, 7, 9, 11);
        System.out.println(getCoinDeterminations(num, coins, coins.size(), new ArrayList<>()));

    }

    static int getCoinDeterminations(int num, List<Integer> coins, int size, List<Integer> determinations) {
        if (num == 0) return determinations.size();
        if (num < 0 || size == 0) return Integer.MAX_VALUE;

        int determinations1 = getCoinDeterminations(num, coins, size - 1, determinations);

        int coin = coins.get(size - 1);
        determinations.add(coin);
        num = num - coin;

        int determinations2 = getCoinDeterminations(num, coins, size, determinations);
        determinations.remove(determinations.size() - 1);

        return Math.min(determinations1, determinations2);
    }
}
