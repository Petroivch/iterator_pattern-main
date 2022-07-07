import java.util.Iterator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        random = new Random();
        this.min = min;
        this.max = max + 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return boundedNextInt(min, max);
            }
        };
    }

    public static int boundedNextInt(int origin, int bound) {
        Random rnm = new Random();
        int r = rnm.nextInt();
        if (origin < bound) {
            final int n = bound - origin;
            final int m = n - 1;
            if ((n & m) == 0) {
                r = (r & m) + origin;
            } else if (n > 0) {
                for (int u = r >>> 1;
                     u + m - (r = u % n) < 0;
                     u = rnm.nextInt() >>> 1)
                    ;
                r += origin;
            } else {
                while (r < origin || r >= bound) {
                    r = rnm.nextInt();
                }
            }
        }
        return r;
    }
}