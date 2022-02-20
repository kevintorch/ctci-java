package stacks_queues.queue;


import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> pollStack = new Stack<>();
    private final Stack<Integer> offerStack = new Stack<>();

    public void offer(Integer value) {
        offerStack.push(value);
    }

    public Integer poll() {
        shiftStacks();
        return pollStack.pop();
    }

    public Integer peek() {
        shiftStacks();
        return pollStack.peek();
    }

    private void shiftStacks() {
        if (pollStack.isEmpty()) {
            while (!offerStack.isEmpty()) {
                pollStack.push(offerStack.pop());
            }
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return pollStack.size() + offerStack.size();
    }
}
