package org.example.stacks_queues.queue;

public class QueueWithoutMaxItems {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;

    public QueueWithoutMaxItems(int maxSize) {
        this.maxSize = maxSize + 1;
        this.queueArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public void insert(long value) {
        if (rear == maxSize) {
            rear = -1;
        }

        queueArray[++rear] = value;
    }

    public long remove() {
        long value = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return value;
    }

    public long peek() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1) == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front || (front + maxSize - 2) == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return (maxSize - front) + (rear + 1);
        }
    }
}
