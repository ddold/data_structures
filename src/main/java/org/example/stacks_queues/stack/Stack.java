package org.example.stacks_queues.stack;

public class Stack {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    // put item at the top of the stack
    public void push(long item) {
        stackArray[++top] = item;
    }

    // take item from top of the stack and remove it
    public long pop() {
        return stackArray[top--];
    }

    // get item from top of stack
    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
