package org.example.stacks_queues.priority_queue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(30);
        queue.insert(50);
        queue.insert(10);
        queue.insert(40);
        queue.insert(20);

        while (!queue.isEmpty()) {
            long item = queue.remove();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
