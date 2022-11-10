package org.example.arrays;

public class HighArray {
    private long[] array;
    private int numOfCellsFilled;

    public HighArray(int max) {
        this.array = new long[max];
        this.numOfCellsFilled = 0;
    }

    // Searching for an element
    public boolean find(long searchKey) {
        return linearSearch(searchKey);
    }

    private boolean linearSearch(long searchKey) {
        for (int i = 0; i < numOfCellsFilled; i++) {
            if (this.array[i] == searchKey) {
                return true;
            }
        }
        return false;
    }

    // Inserting an element
    public void insert(long value) {
        this.array[numOfCellsFilled] = value;
        numOfCellsFilled++;
    }

    // Deleting an element
    public boolean delete(long value) {
        int i;
        for (i = 0; i < numOfCellsFilled; i++) {
            if (value == this.array[i]) {
                break;
            }
        }

        if (i == numOfCellsFilled) {
            return false;
        } else {
            for (int j = i; j < numOfCellsFilled; j++) {
                this.array[j] = this.array[j + 1];
            }
            numOfCellsFilled--;
            return true;
        }
    }

    public long removeMax() {
        long maxValue = -1;
        for (int i = 0; i < numOfCellsFilled; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        delete(maxValue);
        return maxValue;
    }

    public void noDups() {
        for (int i = 0; i < numOfCellsFilled; i++) {
            for (int j = i + 1; j < numOfCellsFilled; j++) {
                if (array[i] == array[j]) {
                    array[j] = -1;
                }
            }
        }

        while (find(-1)) {
            delete(-1);
        }
    }

    // Display the array
    public void display() {
        for (int i = 0; i < numOfCellsFilled; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        HighArray array = new HighArray(maxSize);

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
        array.insert(77);
        array.insert(33);
        array.insert(00);

        array.display();

        System.out.println("The max value in the array is " + array.removeMax());

        int searchKey = 33;
        if (array.find(searchKey)) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }

        array.delete(00);
        array.delete(55);
        array.delete(99);

        array.display();

        System.out.println("The max value in the array is " + array.removeMax());

        array.display();

        array.noDups();

        array.display();

        HighArray simpleSort = new HighArray(maxSize);
        while (true) {
            long max = array.removeMax();
            if (max == -1) {
                break;
            }
            simpleSort.insert(max);
        }
        simpleSort.display();
    }
}
