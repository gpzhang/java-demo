package algorithm;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @author haishen
 * @date 2019/8/21
 * <p>
 * 有1千万个随机数，随机数的范围在1到1亿之间。
 * 将1到1亿之间没有在随机数中的数求出来？
 */
public class BitSetDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int nums = 100000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            int randomInt = random.nextInt(nums);
            list.add(randomInt);
        }
        BitSet bitSet = new BitSet(nums);
        for (int j = 0; j < list.size(); j++) {
            bitSet.set(list.get(j), true);
        }

        System.out.println("不在随机数列表的数字");

        for (int k = 0; k < 10; k++) {
            if (!bitSet.get(k)) {
                System.out.println(k);
            }
        }
    }
}
