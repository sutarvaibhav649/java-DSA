import java.util.Scanner;

class Stack {
    int[] stackArray;
    int size;
    int top;

    public Stack(int size) {
        this.size = size;
        this.top = -1;
        this.stackArray = new int[size];
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++top] = data;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!!!");
            return;
        }
        int popped = stackArray[top--];
        System.out.println("Popped element: " + popped);
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Top element of the stack: " + stackArray[top]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Stack element (top to bottom)");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + "-->");
        }
        System.out.println("END");
    }

};

public class StackArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        Scanner scan = new Scanner(System.in);
        int choice, data;
        while (true) {
            System.out.println("===================== Menu =====================");
            System.out.println("1.Push Element");
            System.out.println("2.Pop Element");
            System.out.println("3.Peek Element");
            System.out.println("4.Display Elements");
            System.out.println("5.Exit");
            System.out.println("===================== Menu =====================");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the data: ");
                    data = scan.nextInt();
                    stack.push(data);
                }
                case 2 -> stack.pop();
                case 3 -> stack.peek();
                case 4 -> stack.displayStack();
                case 5 -> {
                    System.out.println("Exiting program.......");
                    System.out.println("😊😊Good bye😊😊");
                    System.exit(0);
                }
                default -> {
                    System.out.println("❌ Invalid option try again ❌");
                }
            }
            scan.close();
        }

    }
}
