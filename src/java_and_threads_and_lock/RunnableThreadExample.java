package java_and_threads_and_lock;

public class RunnableThreadExample implements Runnable {
    private int count = 0;

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();


        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MySingleton e = MySingleton.INSTANCE;
    }

    @Override
    public void run() {
        System.out.println("Runnable Thread Starting.");
        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("RunnableThread Interrupted.");
        }
        System.out.println("RunnableThread terminating.");
    }
}
