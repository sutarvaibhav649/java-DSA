import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
};

public class StackLinkedList {
    private Node top;

    public StackLinkedList() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Stack is Empty Nothing to pop");
            return;
        }
        top = top.next;
    }

    public void peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Top element: " + top.data);
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return;
        }

        Node temp = top;
        System.out.print("Stack Top -> ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        try (Scanner scan = new Scanner(System.in)) {
            int choice, data;
            while (true) {
                System.out.println("----------------------------------------------");
                System.out.println("1.push into stack");
                System.out.println("2.pop from stack");
                System.out.println("3.peek of stack");
                System.out.println("4.display stack");
                System.out.println("5.Exit");
                System.out.println("----------------------------------------------");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the data: ");
                        data = scan.nextInt();
                        stack.push(data);
                    }
                    case 2 -> {
                        stack.pop();
                    }
                    case 3 -> {
                        stack.peek();
                    }
                    case 4 -> stack.display();
                    case 5 -> {
                        System.out.println("Exiting program...........");
                        System.out.println("😊😊 Good bye 😊😊");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("❌ Invalid option try again ❌");
                    }
                }
            }
        }

    }
}
