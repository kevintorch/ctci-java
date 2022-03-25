package java_and_threads_and_lock.dining_philosphers;

public class Philosopher extends Thread {
    private final Chopstick left;
    private final Chopstick right;
    private int bites = 100;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    private void pickChopsticks() {
        left.pickUp();
        right.pickUp();
    }

    private void putDownChopsticks() {
        left.putDown();
        right.putDown();
    }

    private void eat() {
        pickChopsticks();
        chew();
        putDownChopsticks();
    }

    private void chew() {
    }

    @Override
    public void run() {
        while (bites != 0) {
            eat();
            bites--;
        }
    }
}
