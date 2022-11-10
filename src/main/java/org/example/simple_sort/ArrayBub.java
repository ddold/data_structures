package org.example.simple_sort;

public class ArrayBub {

    private long[] array;
    private int numberOfDataItems;

    public ArrayBub(int max) {
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

    public void bubbleSort() {
        int out;
        int in;

        for (out = numberOfDataItems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (array[in] > array[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}

class BubbleSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayBub array = new ArrayBub(maxSize);

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

        array.bubbleSort();

        array.display();
    }
}
