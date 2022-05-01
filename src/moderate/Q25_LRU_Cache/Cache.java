package moderate.Q25_LRU_Cache;

import java.util.HashMap;

public class Cache {
    private final int maxCacheSize;
    private final HashMap<Integer, LinkedListNode> map = new HashMap<>();
    private LinkedListNode head;
    private LinkedListNode tail;

    public Cache(int cache_size) {
        this.maxCacheSize = cache_size;
    }


    public Object getValue(Integer key) {
        LinkedListNode node = map.get(key);
        if (node == null) return null;

        /* Move to front of list to mark as most recently used. */
        if (node != head) {
            removeFromLinkedList(node);
            insertAtFrontOfLinkedList(node);
        }
        return node.value;
    }

    public void insert(Integer key, Object value) {
        /* Remove if already there. */
        removeKey(key);

        /* if full, remove least recently used item from cache. */
        if (isFull()) {
            removeKey(tail.key);
        }

        /* Insert new node. */
        LinkedListNode node = new LinkedListNode(key, value);
        insertAtFrontOfLinkedList(node);
        map.put(key, node);
    }

    public boolean isFull() {
        return map.size() >= maxCacheSize && tail != null;
    }

    private void removeFromLinkedList(LinkedListNode node) {
        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == tail) tail = node.prev;
        if (node == head) head = node.next;
    }

    private boolean removeKey(int key) {
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    private void insertAtFrontOfLinkedList(LinkedListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public String getCacheAsString() {
        if (head == null) return "";
        return head.printForward();
    }


    private static class LinkedListNode {
        LinkedListNode prev, next;
        Integer key;
        Object value;

        public LinkedListNode(Integer key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String printForward() {
            String data = "(" + key + "," + value + ")";
            if (next != null) {
                return data + "->" + next.printForward();
            } else {
                return data;
            }
        }
    }
}
