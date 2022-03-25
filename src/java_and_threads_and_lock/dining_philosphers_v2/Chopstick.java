package java_and_threads_and_lock.dining_philosphers_v2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private final Lock lock;

    public Chopstick() {
        lock = new ReentrantLock();
    }

    public boolean pickUp() {
        return lock.tryLock();
    }

    public void putDown() {
        lock.unlock();
    }
}
