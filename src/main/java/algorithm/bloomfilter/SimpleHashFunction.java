package algorithm.bloomfilter;

/**
 * @author haishen
 * @date 2019/8/21
 */
public class SimpleHashFunction {

    private int cap;

    private int seed;

    public SimpleHashFunction(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    public int hash(String value) {

        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            result = value.charAt(i) % seed + result;
        }
        return (cap - 1) & result;
    }
}
