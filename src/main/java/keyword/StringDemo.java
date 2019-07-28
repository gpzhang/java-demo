package keyword;

/**
 * @author haishen
 * @date 2019/7/25
 * <p>
 * String 字符串的hashcode()计算逻辑
 * s[0]*31^(n-1)+s[1]*31^(n-2)+...+s[n-1]*31^0
 * 31是一个奇质数，另外java虚拟机可以对31*i优化成（i<<<5）-i
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "123";
        String s = "123";
        System.out.println(s.equals(str));

        System.out.println(str.hashCode());
    }
}
