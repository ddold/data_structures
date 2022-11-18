package org.example.stacks_queues.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackY {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackY(int maxSize) {
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

    public int size() {
        return top + 1;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void display(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom --> top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println();
    }
}

class InfixToPostfix {
    private StackY stack;
    private String input;
    private String output;

    public InfixToPostfix(String input) {
        this.input = input;
        int stackSize = input.length();
        this.stack = new StackY(stackSize);
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.display("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output += ch;
                    break;
            }
        }

        while (!stack.isEmpty()) {
            stack.display("While ");
            output += stack.pop();
        }

        stack.display("End ");
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();

            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        }
        stack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }
}

public class Infix {
    public static void main(String[] args) throws IOException {
        String input;
        String output;

        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }

            InfixToPostfix trans = new InfixToPostfix(input);
            output = trans.doTrans();
            System.out.println("Postfix is " + output + '\n');
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
