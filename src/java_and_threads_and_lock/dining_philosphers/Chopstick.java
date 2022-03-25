package java_and_threads_and_lock.dining_philosphers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private final Lock lock;

    public Chopstick() {
        this.lock = new ReentrantLock();
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
