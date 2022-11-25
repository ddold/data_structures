package org.example.linked_lists.link_list;

public class LinkList2App {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);

        list.displayList();

        Link found = list.find(44);
        if (found != null) {
            System.out.println("Found link with key " + found.iData);
        } else {
            System.out.println("Can't find link");
        }

        Link deleted = list.delete(66);
        if (deleted != null) {
            System.out.println("Deleted link with key " + deleted.iData);
        } else {
            System.out.println("Can't delete link");
        }

        list.displayList();
    }
}
