package stacks_queues.stack_min;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if (value <= min())
            s2.push(value);
        super.push(value);
    }

    public Integer pop() {
        Integer pop = super.pop();
        if (pop == min())
            s2.pop();
        return pop;
    }

    public int min() {
        if (s2.isEmpty()) return Integer.MAX_VALUE;
        return s2.peek();
    }
}
