package org.example.stacks_queues.priority_queue;

public class PriorityQueue {

    private int maxSize;
    private long[] queue;
    private int numberOfItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new long[maxSize];
        this.numberOfItems = 0;
    }

    public void insert(long item) {
        int index;
        if (numberOfItems == 0) {
            queue[numberOfItems++] = item;
        } else {
            for (index = numberOfItems - 1; index >= 0; index--) {
                if (item > queue[index]) {
                    queue[index + 1] = queue[index];
                } else {
                    break;
                }
            }
            queue[index + 1] = item;
            numberOfItems++;
        }
    }

    public long remove() {
        return queue[--numberOfItems];
    }

    public long peekMin() {
        return queue[numberOfItems - 1];
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        return numberOfItems == maxSize;
    }
}
