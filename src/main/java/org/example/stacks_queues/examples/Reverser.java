package org.example.stacks_queues.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    // put item at the top of the stack
    public void push(char item) {
        stackArray[++top] = item;
    }

    // take item from top of the stack and remove it
    public char pop() {
        return stackArray[top--];
    }

    // get item from top of stack
    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}

public class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX stack = new StackX(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        output = "";
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            output += ch;
        }

        return output;
    }
}

class ReverserApp {
    public static void main(String[] args) throws IOException {
        String input;
        String output;

        while (true) {
            System.out.print("Enter a string: ");
            System.out.flush();

            input = getString();
            if (input.equals("")) {
                break;
            }

            Reverser rev = new Reverser(input);
            output = rev.doRev();
            System.out.println("Reversed: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
