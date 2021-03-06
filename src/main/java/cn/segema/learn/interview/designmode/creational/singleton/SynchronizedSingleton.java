package cn.segema.learn.interview.designmode.creational.singleton;

/**
 * @description synchronized单例
 * @author wangyong
 * @createDate 2020/08/25
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance = null;

    private SynchronizedSingleton() {}

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
    }

    public static SynchronizedSingleton getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    // 业务逻辑方法
    public String sayHello(String param) {
        System.out.println(param);
        System.out.println("SynchronizedSingleton");
        return "sayHello";
    }

}
