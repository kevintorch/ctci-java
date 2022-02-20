package stacks_queues;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T data) {
        Node<T> tNode = new Node<>(data);
        if (last != null) {
            last.next = tNode;
        }
        last = tNode;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return value;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}
