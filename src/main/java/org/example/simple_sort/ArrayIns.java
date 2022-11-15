package org.example.simple_sort;

public class ArrayIns {
    private long[] array;
    private int numberOfDataItems;

    public ArrayIns(int max) {
        array = new long[max];
        numberOfDataItems = 0;
    }

    public void insert(long value) {
        array[numberOfDataItems] = value;
        numberOfDataItems++;
    }

    public void display() {
        for (int i = 0; i < numberOfDataItems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort() {
        int in;
        int out;

        for (out = 1; out < numberOfDataItems; out++) {
            long temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
                array[in] = temp;
            }
        }
    }
}

class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns array = new ArrayIns(maxSize);

        array.insert(77);
        array.insert(99);
        array.insert(44);
        array.insert(55);
        array.insert(22);
        array.insert(88);
        array.insert(11);
        array.insert(00);
        array.insert(66);
        array.insert(33);

        array.display();

        array.insertionSort();

        array.display();
    }
}
