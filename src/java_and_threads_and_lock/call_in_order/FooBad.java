package java_and_threads_and_lock.call_in_order;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBad {
    private final Lock lock1;
    private final Lock lock2;

    public FooBad() {

        lock1 = new ReentrantLock();
        lock2 = new ReentrantLock();

        lock1.lock();
        lock2.lock();

    }

    public void first() {
        lock1.unlock();
    }

    public void second() {
        lock1.lock();
        lock1.unlock();

        lock2.unlock();
    }

    public void third() {
        lock2.lock();
        lock2.unlock();

    }
}
