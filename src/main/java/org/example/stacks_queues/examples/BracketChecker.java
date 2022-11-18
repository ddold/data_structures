package org.example.stacks_queues.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackW {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackW(int maxSize) {
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

public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackW stack = new StackW(stackSize);

        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{')  ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.err.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.err.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            System.err.println("Error: missing right delimiter");
        }
    }
}

class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();

            if (input.equals("")) {
                break;
            }

            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}