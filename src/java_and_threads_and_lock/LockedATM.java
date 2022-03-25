package java_and_threads_and_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {
    protected Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
    }

    public int withdraw(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp -= value;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException e) {
        }
        lock.unlock();
        return temp;
    }
}
