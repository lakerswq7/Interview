package highfrequency;

/*
 * http://www.lintcode.com/en/problem/trailing-zeros/
 */
public class TrailingZeros {
    public long trailingZeros(long n) {
        if (n < 0) {
            return -1;
        }
        long count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
