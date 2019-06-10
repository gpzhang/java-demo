package thread;

/**
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
