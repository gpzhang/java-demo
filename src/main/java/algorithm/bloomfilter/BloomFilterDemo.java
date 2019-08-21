package algorithm.bloomfilter;

import java.util.BitSet;

/**
 * @author haishen
 * @date 2019/8/21
 * 布隆过滤器实现demo
 * 减少无效的访问
 * <p>
 * 本质上布隆过滤器是一种数据结构，比较巧妙的概率型数据结构（probabilistic data structure），
 * 特点是高效地插入和查询，可以用来告诉你 “某样东西一定不存在或者可能存在”。侧重对存不存在的判断，精确判断不存在，猜测判断存在
 * <p>
 * 相比于传统的 List、Set、Map 等数据结构，它更高效、占用空间更少，但是缺点是其返回的结果是概率性的，而不是确切的。
 * <p>
 * 布隆过滤器原理
 * 布隆过滤器（Bloom Filter）的核心实现是一个超大的位数组和几个哈希函数。
 * 假设位数组的长度为m（最好大一点），哈希函数的个数为k（要考虑hash结果的均匀分布）
 * <p>
 * 添加元素操作：
 * 将要添加的元素给k个哈希函数（得到k个hash值）
 * 对应于位数组上的k个位置
 * 将这k个位置的值设为1
 * <p>
 * 查询元素操作：
 * 将要查询的元素给k个哈希函数
 * 得到对应于位数组上的k个位置
 * 如果k个位置有一个为0，则肯定不在集合中
 * 如果k个位置全部为1，则可能在集合中
 */
public class BloomFilterDemo {
    private static final int DEFAULT_SIZE = Integer.MAX_VALUE;

    /**
     * 通过BitSet可以检测一个数字是否存在
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    private static final int[] seeds = new int[]{7, 11, 13};


    private static SimpleHashFunction[] functions = new SimpleHashFunction[seeds.length];

    public BloomFilterDemo() {
        for (int i = 0; i < seeds.length; i++) {
            functions[i] = new SimpleHashFunction(DEFAULT_SIZE, seeds[i]);
        }
    }

    /**
     * 添加元素
     *
     * @param value
     */
    public void add(String value) {
        for (SimpleHashFunction function : functions) {
            bits.set(function.hash(value), true);
        }
    }

    /**
     * 判断元素是否存在
     *
     * @param value
     * @return
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean result = true;
        for (SimpleHashFunction function : functions) {
            result = result & bits.get(function.hash(value));
        }
        return result;
    }

    public static void main(String[] args) {
        String value = "sfdafadfds";
        BloomFilterDemo bloomFilterDemo = new BloomFilterDemo();
        System.out.println(bloomFilterDemo.contains(value));
        bloomFilterDemo.add(value);
        System.out.println(bloomFilterDemo.contains(value));

    }


}
