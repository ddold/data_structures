package org.example.stacks_queues.queue;

public class Queue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int numberOfItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new long[maxSize];
        front = 0;
        rear = -1;
        numberOfItems = 0;
    }

    // put item at end of the queue
    public void insert(long value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
        numberOfItems++;
    }

    // take item from front of the queue
    public long remove() {
        long temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        numberOfItems--;
        return temp;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return numberOfItems == 0;
    }

    public boolean isFull() {
        return numberOfItems == maxSize;
    }

    public int size() {
        return numberOfItems;
    }
}
