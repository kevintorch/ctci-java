package java_and_threads_and_lock.deadlock_free_class;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class LockFactory {
    private static LockFactory instance;

    private final LockNode[] locks;

    private final HashMap<Integer, LinkedList<LockNode>> lockOrder;

    private LockFactory(int count) {
        locks = new LockNode[count];
        lockOrder = new HashMap<>();
        for (int i = 0; i < count; i++) {
            locks[i] = new LockNode(i, count);
        }
    }

    public static LockFactory getInstance() {
        return instance;
    }

    public static synchronized LockFactory initialize(int count) {
        if (instance == null) {
            instance = new LockFactory(count);
        }
        return instance;
    }

    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes, int[] resourcesInOrder) {
        for (int resource : resourcesInOrder) {
            if (!touchedNodes.get(resource)) {
                LockNode n = locks[resource];
                if (n.hasCycle(touchedNodes)) return true;
            }
        }
        return false;
    }

    public boolean declare(int ownerId, int[] resourcesInOrder) {
        HashMap<Integer, Boolean> touchedNodes = new HashMap<>();

        touchedNodes.put(resourcesInOrder[0], false);
        for (int index = 1; index < resourcesInOrder.length; index++) {
            LockNode prev = locks[resourcesInOrder[index - 1]];
            LockNode curr = locks[resourcesInOrder[index]];
            prev.joinTo(curr);
            touchedNodes.put(resourcesInOrder[index], false);
        }

        if (hasCycle(touchedNodes, resourcesInOrder)) {
            for (int j = 1; j < resourcesInOrder.length; j++) {
                LockNode p = locks[resourcesInOrder[j - 1]];
                LockNode c = locks[resourcesInOrder[j]];
                p.remove(c);
            }
            return false;
        }

        LinkedList<LockNode> list = new LinkedList<>();
        for (int i = 0; i < resourcesInOrder.length; i++) {
            LockNode res = locks[resourcesInOrder[i]];
            list.add(res);
        }
        lockOrder.put(ownerId, list);
        return true;
    }

    public Lock getLock(int ownerId, int resourceID) {
        LinkedList<LockNode> list = lockOrder.get(ownerId);
        if (list == null) return null;

        LockNode head = list.getFirst();
        if (head.getId() == resourceID) {
            list.removeFirst();
            return head.getLock();
        }
        return null;
    }
}
