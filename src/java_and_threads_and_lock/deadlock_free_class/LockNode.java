package java_and_threads_and_lock.deadlock_free_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockNode {
    private final int id;
    private final int maxLocks;
    List<LockNode> children;
    private Lock lock;

    public LockNode(int id, int max) {
        this.id = id;
        children = new ArrayList<>();
        maxLocks = max;
    }

    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
        VisitState[] visitStates = new VisitState[maxLocks];
        Arrays.fill(visitStates, VisitState.FRESH);
        return hasCycle(visitStates, touchedNodes);
    }

    public boolean hasCycle(VisitState[] visitStates, HashMap<Integer, Boolean> touchedNodes) {
        if (touchedNodes.containsKey(id)) {
            touchedNodes.put(id, true);
        }

        if (visitStates[id] == VisitState.VISITING) return true;
        else if (visitStates[id] == VisitState.FRESH) {
            visitStates[id] = VisitState.VISITING;
            for (LockNode n : children) {
                if (n.hasCycle(visitStates, touchedNodes)) return true;
            }
            visitStates[id] = VisitState.VISITED;
        }
        return false;
    }

    public void joinTo(LockNode node) {
        children.add(node);
    }

    public void remove(LockNode node) {
        children.remove(node);
    }

    public Lock getLock() {
        if (lock == null) {
            lock = new ReentrantLock();
        }
        return lock;
    }

    public int getId() {
        return id;
    }

    public enum VisitState {FRESH, VISITING, VISITED}
}
