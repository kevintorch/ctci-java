package java_and_threads_and_lock.call_in_order;

import java.util.concurrent.Semaphore;

public class Foo {
    private final Semaphore s1;
    private final Semaphore s2;

    public Foo() {
        s1 = new Semaphore(1);
        s2 = new Semaphore(1);

        try {
            s1.acquire();
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first() {
        s1.release();
    }

    public void second() {
        try {
            s1.acquire();
            s1.release();

            s2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            s2.acquire();
            s2.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
