package org.example.arrays;

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

class ClassDataArray {
    private Person[] array;
    private int numOfCellsFilled;

    public ClassDataArray(int max) {
        array = new Person[max];
        numOfCellsFilled = 0;
    }

    public Person find(String searchName) {
        int i;
        for (i = 0; i < numOfCellsFilled; i++) {
            if (array[i].getLastName().equals(searchName)) {
                break;
            }
        }

        if (i == numOfCellsFilled) {
            return null;
        } else {
            return array[i];
        }
    }

    public void insert(String last, String first, int age) {
        array[numOfCellsFilled] = new Person(last, first, age);
        numOfCellsFilled++;
    }

    public boolean delete(String searchName) {
        int i;
        for (i = 0; i < numOfCellsFilled; i++) {
            if (array[i].getLastName().equals(searchName)) {
                break;
            }
        }
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

    public void display() {
        for (int i = 0; i < numOfCellsFilled; i++) {
            array[i].display();
        }
    }
}

class ClassDataApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ClassDataArray array = new ClassDataArray(maxSize);

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

        array.display();

        String searchKey = "Stimson";
        Person found;
        found = array.find(searchKey);
        if (found != null) {
            System.out.print("Found ");
            found.display();
        } else {
            System.out.println("Can't find " + searchKey);
        }

        System.out.println("Deleting Smith, Yee and Creswell");
        array.delete("Smith");
        array.delete("Yee");
        array.delete("Creswell");

        array.display();
    }
}
