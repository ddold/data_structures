package org.example.linked_lists.list_insertion_sort;

public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;

        Link[] array = new Link[size];

        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 99);
            Link newLink = new Link(n);
            array[i] = newLink;
        }

        System.out.print("Unsorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i].dData + " ");
        }
        System.out.println();

        SortedList sortedList = new SortedList(array);

        for (int i = 0; i < size; i++) {
            array[i] = sortedList.remove();
        }

        System.out.print("Sorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i].dData + " ");
        }
        System.out.println();
    }
}
