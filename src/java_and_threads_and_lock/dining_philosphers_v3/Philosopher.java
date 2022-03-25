package java_and_threads_and_lock.dining_philosphers_v3;

import others.AssortedMethods;

public class Philosopher extends Thread {
    private final Chopstick lower;
    private final Chopstick higher;
    private final int maxPause = 100;
    private final int index;
    private int bites = 10;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        } else {
            this.lower = right;
            this.higher = left;
        }
    }

    private void eat() {
        System.out.println("Philosopher " + index + ": start eating");
        pickChopsticks();
        chew();
        putDownChopsticks();
        System.out.println("Philosopher " + index + ": done eating");
    }

    private void pickChopsticks() {
        pause();
        lower.pickUp();
        pause();
        higher.pickUp();
        pause();
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
        higher.putDown();
        lower.putDown();
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
