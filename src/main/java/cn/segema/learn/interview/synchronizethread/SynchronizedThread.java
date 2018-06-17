package cn.segema.learn.interview.synchronizethread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步的运用
 */
public class SynchronizedThread {

    class Bank {

        private volatile int account = 100;
        
        //需要声明这个锁
        private Lock lock = new ReentrantLock();

        public int getAccount() {
            return account;
        }

        /**
         * 用同步方法实现
         * 
         * @param money
         */
        public synchronized void save(int money) {
            account += money;
        }

        /**
         * 用同步代码块实现
         * 
         * @param money
         */
        public void save1(int money) {
            synchronized (this) {
                account += money;
            }
        }
        
        /**
         * 用锁实现
         * 
         * @param money
         */
        public  void save2(int money) {
        	 	lock.lock();
             try{
                 account += money;
             }finally{
                 lock.unlock();
             }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.save1(10);
             //  bank.save(10);
                System.out.println(i + "账户余额为：" + bank.getAccount());
            }
        }

    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();
        System.out.println("线程2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        st.useThread();
    }

}