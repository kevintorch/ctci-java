package hard.Q20_Continuous_Median;

import java.util.PriorityQueue;

public class QuestionA {
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());

    public static void main(String[] args) {

    }

    private static void feed(int number) {
        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.peek() != null && minHeap.peek() < number) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(number);
            } else {
                maxHeap.offer(number);
            }
        } else {
            if (maxHeap.peek() != null && maxHeap.peek() > number) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(number);
            } else {
                minHeap.offer(number);
            }
        }
    }

    private static double getMedian() {
        if (maxHeap.isEmpty()) return 0;
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }

}
