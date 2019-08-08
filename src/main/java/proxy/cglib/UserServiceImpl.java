package proxy.cglib;

/**
 * @author haishen
 * @date 2019/8/5
 */
public class UserServiceImpl {

    public String getName(int id) {
        System.out.println("获取" + id + "的姓名");
        return "Tom";
    }

    public int getAge(int id) {
        System.out.println("获取" + id + "的年龄");
        return 10;
    }

}
