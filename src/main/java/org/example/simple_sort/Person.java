package org.example.simple_sort;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void display() {
        System.out.print("Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    public String getLastName() {
        return lastName;
    }
}

class ArrayInOb {

    private Person[] array;
    private int numberOfDataItems;

    public ArrayInOb(int max) {
        array = new Person[max];
        numberOfDataItems = 0;
    }

    public void insert(String last, String first, int age) {
        array[numberOfDataItems] = new Person(last, first, age);
        numberOfDataItems++;
    }

    public void display() {
        for (int i = 0; i < numberOfDataItems; i++) {
            array[i].display();
        }
    }

    public void insertionSort() {
        int in;
        int out;

        for (out = 1; out < numberOfDataItems; out++) {
            Person temp = array[out];
            in = out;

            while (in > 0 && array[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}

class ObjectSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayInOb array = new ArrayInOb(maxSize);

        array.insert("Evans", "Patty", 24);
        array.insert("Smith", "Lorraine", 37);
        array.insert("Yee", "Tom", 43);
        array.insert("Adams", "Henry", 63);
        array.insert("Hashimoto", "Soto", 21);
        array.insert("Stimson", "Henry", 29);
        array.insert("Velasquez", "Jose", 72);
        array.insert("Lamarque", "Henry", 54);
        array.insert("Vang", "Minh", 22);
        array.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting:");
        array.display();

        array.insertionSort();

        System.out.println("After sorting:");
        array.display();
    }
}
