package stacks_queues.three_in_one;

//

import java.util.EmptyStackException;

public class FixedMultiStack {
    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (stackNum > numberOfStacks || isFull(stackNum)) throw new FullStackException();
        values[indexOfTop(stackNum)] = value;
        sizes[stackNum]++;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();
        int value = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = -1;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
