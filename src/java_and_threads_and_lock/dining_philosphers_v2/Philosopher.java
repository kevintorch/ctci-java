package java_and_threads_and_lock.dining_philosphers_v2;

import others.AssortedMethods;

public class Philosopher extends Thread {
    private final Chopstick left;
    private final Chopstick right;
    private final int maxPause = 100;
    private final int index;
    private int bites = 10;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        this.left = left;
        this.right = right;
    }

    private void eat() {
        System.out.println("Philosopher " + index + ": start eating");
        if (pickChopsticks()) {
            chew();
            putDownChopsticks();
            System.out.println("Philosopher " + index + ": done eating");
        } else {
            System.out.println("Philosopher " + index + ": gave up on eating");
        }
    }

    private boolean pickChopsticks() {
        pause();
        if (!left.pickUp()) {
            return false;
        }
        pause();
        if (!right.pickUp()) {
            left.putDown();
            return false;
        }
        pause();
        return true;
    }

    public void pause() {
        try {
            int pause = AssortedMethods.randomIntInRange(0, maxPause);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void putDownChopsticks() {
        left.putDown();
        right.putDown();
    }

    private void chew() {
        System.out.println("Philosopher " + index + ": eating");
        pause();
    }

    @Override
    public void run() {
        while (bites != 0) {
            eat();
            bites--;
        }
    }
}
