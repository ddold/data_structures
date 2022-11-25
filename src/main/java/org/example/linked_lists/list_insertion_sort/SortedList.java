package org.example.linked_lists.list_insertion_sort;

public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    public SortedList(Link[] array) {
        first = null;
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public void insert(Link link) {
        Link previousLink = null;
        Link currentLink = first;

        while (currentLink != null && link.dData > currentLink.dData) {
            previousLink = currentLink;
            currentLink = currentLink.next;
        }

        if (previousLink == null) {
            first = link;
        } else {
            previousLink.next = link;
        }

        link.next = currentLink;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }
}
