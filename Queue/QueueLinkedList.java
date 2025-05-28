import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
};

public class QueueLinkedList {
    Node front = null;
    Node rear = null;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null && rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        front = front.next;
        temp.next = null;
    }

    public void front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("First element of queue: " + front.data);
    }

    public boolean isEmpty() {
        return rear == null && front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        Node current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        try (Scanner scan = new Scanner(System.in)) {
            int choice, data;
            while (true) {
                System.out.println("----------------------------------------------");
                System.out.println("1.Insert into Queue");
                System.out.println("2.Remove from Queue");
                System.out.println("3.Front of Queue");
                System.out.println("4.Display Queue");
                System.out.println("5.Exit");
                System.out.println("----------------------------------------------");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the data: ");
                        data = scan.nextInt();
                        queue.enqueue(data);
                    }
                    case 2 -> {
                        queue.dequeue();
                    }
                    case 3 -> {
                        queue.front();
                    }
                    case 4 -> queue.displayQueue();
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
};
