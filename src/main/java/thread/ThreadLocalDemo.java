package thread;

/**
 * 根据当前线程对象获取当前线程的属性ThreadLocal.ThreadLocalMap;
 * ThreadLocal.ThreadLocalMap 持有一个数组对象table,数组对象的元素为Entry,
 * 其中元素的位置索引是基于定义的ThreadLocal对象的hashcode计算得出的,对于出现hash碰撞的情况,ThreadLocalMap采用开放地址法处理hash冲突
 * Entry是一个以ThreadLocal为key,Object为value的键值对;
 * 定义多少个ThreadLocal对象,当前线程的的属性ThreadLocal.ThreadLocalMap的数组对象中就会有多少个ThreadLocal对象.
 *
 * @author haishen
 * @date 2018/7/17
 */
public class ThreadLocalDemo {

    private static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();
    private static int k = 0;

    public static void main(String[] args) {

        System.out.println("ThreadLocal实例:" + userInfoThreadLocal);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            if (userInfoThreadLocal.get() == null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setAge(12);
                userInfo.setName(Thread.currentThread().getName());
                userInfoThreadLocal.set(userInfo);
            }
            UserInfo value = userInfoThreadLocal.get();
            userInfoThreadLocal.remove();
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(value.getAge() + 10);
            userInfo.setName(Thread.currentThread().getName());
            userInfoThreadLocal.set(userInfo);
            System.out.println("线程<" + Thread.currentThread().getName() + ">i值:" + userInfoThreadLocal.get());
        }
    }
}
