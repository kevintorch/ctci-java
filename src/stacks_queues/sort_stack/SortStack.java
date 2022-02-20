package stacks_queues.sort_stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();

    }

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> r = new Stack<>();
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                stack.push(r.pop());
            }
            r.push(tmp);
        }
        while (!r.isEmpty()) {
            stack.push(r.pop());
        }
    }
}
