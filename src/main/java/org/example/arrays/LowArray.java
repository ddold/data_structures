package org.example.arrays;

public class LowArray {

    private long[] array;

    public LowArray(int size) {
        this.array = new long[size];
    }

    public void setElement(int index, long value) {
        array[index] = value;
    }

    public long getElement(int index) {
        return array[index];
    }
}

class LowArrayApp {
    public static void main(String[] args) {
        LowArray array = new LowArray(100);
        int numElements = 0;
        int i;

        array.setElement(0, 77);
        array.setElement(1, 99);
        array.setElement(2, 44);
        array.setElement(3, 55);
        array.setElement(4, 22);
        array.setElement(5, 88);
        array.setElement(6, 11);
        array.setElement(7, 00);
        array.setElement(8, 66);
        array.setElement(9, 33);
        numElements = 10;

        // display elements
        for (i = 0; i < numElements; i++) {
            System.out.print(array.getElement(i) + " ");
        }
        System.out.println();

        // Search for data element
        int searchKey = 26;
        for (i = 0; i < numElements; i++) {
            if (array.getElement(i) == searchKey) {
                break;
            }
        }
        if (i == numElements) {
            System.out.println("Can't find " + searchKey);
        } else {
            System.out.println("Found " + searchKey);
        }

        // Delete element
        for (i = 0; i < numElements; i++) {
            if (array.getElement(i) == 55) {
                break;
            }
        }

        for (int j = i; j < numElements; j++) {
            array.setElement(j, array.getElement(j + 1));
        }

        numElements--;

        // Display elements
        for (i = 0; i < numElements; i++) {
            System.out.print(array.getElement(i) + " ");
        }
        System.out.println();
    }
}
