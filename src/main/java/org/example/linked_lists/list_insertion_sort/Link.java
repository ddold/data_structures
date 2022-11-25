package org.example.linked_lists.list_insertion_sort;

public class Link {

    public long dData;
    public Link next;

    public Link(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
