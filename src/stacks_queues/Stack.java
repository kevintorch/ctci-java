package stacks_queues;

import java.util.EmptyStackException;

//

public class Stack<T> {

    private Node<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        Node<T> n = top;
        top = top.next;
        return n.value;
    }

    public void push(T data) {
        Node<T> tNode = new Node<>(data);
        tNode.next = top;
        top = tNode;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static class Node<T> {
        private final T value;
        private Stack.Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}
