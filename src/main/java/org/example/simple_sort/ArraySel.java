package org.example.simple_sort;

public class ArraySel {
    private long[] array;
    private int numberOfDataItems;

    public ArraySel(int max) {
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

    public void selectionSort() {
        int out;
        int in;
        int min;

        for (out = 0; out < numberOfDataItems - 1; out++) {
            min = out;
            for (in = out + 1; in < numberOfDataItems; in++) {
                if (array[in] < array[min]) {
                    min = in;
                    swap(out, min);
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

class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySel array = new ArraySel(maxSize);

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

        array.selectionSort();

        array.display();
    }
}
