package org.example.arrays;

public class OrderedArray {
    private long[] array;
    private int numOfCellsFilled;

    public OrderedArray(int max) {
        array = new long[max];
        numOfCellsFilled = 0;
    }

    public int size() {
        return numOfCellsFilled;
    }

    public int find(long searchKey) {
        return binarySearch(searchKey);
    }

    private int binarySearch(long searchKey) {
        int lowerBound = 0;
        int upperBound = numOfCellsFilled - 1;
        int currentIndex;

        while (true) {
            currentIndex = (lowerBound + upperBound) / 2;
            if (array[currentIndex] == searchKey) {
                return currentIndex;
            } else if (lowerBound > upperBound) {
                // Can't find it
                return numOfCellsFilled;
            } else {
                if (array[currentIndex] < searchKey) {
                    lowerBound = currentIndex + 1;
                } else {
                    upperBound = currentIndex - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int currentIndex;

        for (currentIndex = 0; currentIndex < numOfCellsFilled; currentIndex++) {
            if (array[currentIndex] > value) {
                break;
            }
        }

        for (int j = numOfCellsFilled; j > currentIndex; j--) {
            array[j] = array[j - 1];
        }

        array[currentIndex] = value;
        numOfCellsFilled++;
    }

    public boolean delete(long value) {
        int i = binarySearch(value);
        if (i == numOfCellsFilled) {
            return false;
        } else {
            for (int j = i; j < numOfCellsFilled; j++) {
                array[j] = array[j + 1];
            }
            numOfCellsFilled--;
            return true;
        }
    }

    public static OrderedArray merge(long[] array1, long[] array2) {
        int maxSize = array1.length + array2.length;
        OrderedArray mergedArray = new OrderedArray(maxSize);
        for (int i = 0; i < array1.length; i++) {
            mergedArray.insert(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            mergedArray.insert(array2[i]);
        }

        return mergedArray;
    }

    public void display() {
        for (int i = 0; i < numOfCellsFilled; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray array = new OrderedArray(maxSize);

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

        int searchKey = 55;
        if (array.find(searchKey) != array.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        array.delete(00);
        array.delete(55);
        array.delete(99);

        array.display();

        long[] array1 = new long[] {1, 6, 2, 9, 5};
        long[] array2 = new long[] {4, 0, 8, 3, 7};
        OrderedArray orderedArray = OrderedArray.merge(array1, array2);
        orderedArray.display();
    }
}
