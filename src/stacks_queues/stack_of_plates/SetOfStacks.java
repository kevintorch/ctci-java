package stacks_queues.stack_of_plates;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
    private final ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private final int stackCapacity;

    public SetOfStacks(int singleStackSize) {
        this.stackCapacity = singleStackSize;
    }

    public void push(Integer value) {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null || lastStack.size() == stackCapacity) {
            stacks.add(new Stack<>());
        }
        getLastStack().push(value);
    }

    public Integer pop() {
        Stack<Integer> lastStack = getLastStack();
        if (lastStack == null) return null;
        Integer pop = lastStack.pop();
        if (lastStack.isEmpty()) {
            stacks.remove(lastStackIndex());
        }
        return pop;
    }

    // TODO:- Review
    // It's Pop at stack index, not element index.
    public Integer popAt(int index) {
        int stackIndex = index / stackCapacity;
        int nodeIndex = index % stackCapacity;
        Stack<Integer> integers = stacks.get(stackIndex);
        return integers.elementAt(nodeIndex);
    }

    private Stack<Integer> getLastStack() {
        int lastStackIndex = lastStackIndex();
        if (lastStackIndex == -1) return null;
        return stacks.get(lastStackIndex);
    }

    private int lastStackIndex() {
        return stacks.size() - 1;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return stacks.get(lastStackIndex()).peek();
    }

    public boolean isEmpty() {
        Stack<Integer> lastStack = getLastStack();
        return stacks.isEmpty() || (lastStack != null && lastStack.isEmpty());
    }
}
