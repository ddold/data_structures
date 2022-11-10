package org.example.arrays;

public class ArrayApp {
    public static void main(String[] args) {
        long[] array;               // Declaring array
        array = new long[10];      // Initializing array
        int numElems = 0;           // num of elements
        int i;                      // loop counter
        long searchKey;             // key of item to search for
        boolean foundValue = false;

        array[0] = 77;
        array[1] = 99;
        array[2] = 44;
        array[3] = 55;
        array[4] = 22;
        array[5] = 88;
        array[6] = 11;
        array[7] = 00;
        array[8] = 66;
        array[9] = 33;
        numElems = array.length;

        // Display elements
        for (i = 0; i < numElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Search for an element
        searchKey = 66;
        for (i = 0; i < numElems; i++) {
            if (array[i] == searchKey) {
                foundValue = true;
                break;
            }
        }

        if (foundValue) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        // Delete an element
        searchKey = 55;
        for (i = 0; i < numElems; i++) {
            if (array[i] == searchKey) {
                break;
            }
        }

        for (int j = i; j < numElems - 1; j++) {
            array[j] = array[j + 1];
        }

        numElems--;

        // Display elements
        for (i = 0; i < numElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
