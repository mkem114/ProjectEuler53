import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    public static final int MAX_VALUE_OF_N = 100;
    public static final double ONE_MILLION = 1_000_000D;

    public static void main(String[] args) {
        int count = 0;
        for (int n = 1; n <= MAX_VALUE_OF_N; n++) {
            for (int r = 1; r <= n; r++) {
                if (combinations(n, r) > ONE_MILLION) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static double combinations(final int n, final int r) {
        final List<Integer> numeratorFactors = getFactors(n).toList();
        final List<Integer> denominatorFactors = Stream.concat(getFactors(r), getFactors(n - r)).toList();
        return multipleFactors(numeratorFactors) / multipleFactors(denominatorFactors);
    }

    private static Stream<Integer> getFactors(final int n) {
        return IntStream.range(1, n + 1).boxed();
    }

    private static double multipleFactors(final List<Integer> factors) {
        // Only doubles can hold the values without overflowing
        return factors.stream().map(Double::valueOf).reduce(1D, (a, b) -> a * b);
    }
}
