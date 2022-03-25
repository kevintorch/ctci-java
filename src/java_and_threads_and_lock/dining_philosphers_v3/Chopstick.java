package java_and_threads_and_lock.dining_philosphers_v3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private final int number;
    private final Lock lock;

    public Chopstick(int number) {
        this.number = number;
        lock = new ReentrantLock();
    }

    public int getNumber() {
        return number;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
