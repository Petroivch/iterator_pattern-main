import java.util.Iterator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    protected int min;
    protected int max;

    protected int randomValue;

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
                randomValue = random.nextInt(max - min) + min;
                return randomValue;
            }
        };
    }
}
