package org.example.linked_lists.queue_list;

public class Link {

    public double dData;
    public Link next;

    public Link(double dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
