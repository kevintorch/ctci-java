package stacks_queues.three_in_one;

// Describe how you could use a single array to implement three stacks.

public class ThreeInOne {
    private final Object[] array;
    private final StackInfo stack1;
    private final StackInfo stack2;
    private final StackInfo stack3;

    ThreeInOne(int size) {
        array = new Object[size * 3];
        stack1 = new StackInfo(size - 1);
        stack2 = new StackInfo((2 * size) - 1);
        stack3 = new StackInfo((3 * size) - 1);
    }

    public static void main(String[] args) {

    }

    public void addToStack(int data, int stackNumber) {

    }

    class StackInfo {
        private final int top;

        StackInfo(int topIndex) {
            this.top = topIndex;
        }
    }
}
