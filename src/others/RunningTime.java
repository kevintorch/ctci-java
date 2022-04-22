package others;

public final class RunningTime {
    public static void of(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long elapsedNanos = System.nanoTime();
        System.out.println("Running Time::" +
                runnable.getClass().getSimpleName() +
                ": Elapsed Time = " + (elapsedNanos - startTime));
    }
}
