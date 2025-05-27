import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
};

class SinglyLinkedList {
    Node head;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of Bound");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtBeginning(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteFromPosition(int position) {
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bound");
            return;
        }

        Node deletedNode = temp.next;
        temp.next = temp.next.next;
        deletedNode.next = null;
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Invalid position");
            return;
        }
        Node nodeToDelete = temp.next;
        temp.next = null;
        nodeToDelete.next = null;
    }

    public void displayList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        try (Scanner scan = new Scanner(System.in)) {
            int choice, data, position;
            while (true) {
                System.out.println("----------------------------------------------");
                System.out.println("1.Insert at Beginning");
                System.out.println("2.Insert at Position");
                System.out.println("3.Insert at End");
                System.out.println("4.Delete From Beginning");
                System.out.println("5.Delete From Position");
                System.out.println("6.Delete From End");
                System.out.println("7.Display List");
                System.out.println("8.Exit");
                System.out.println("----------------------------------------------");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the data: ");
                        data = scan.nextInt();
                        sll.insertAtBeginning(data);
                    }
                    case 2 -> {
                        System.out.print("Enter the data: ");
                        data = scan.nextInt();
                        System.out.print("Enter the position: ");
                        position = scan.nextInt();
                        sll.insertAtPosition(data, position);
                    }
                    case 3 -> {
                        System.out.print("Enter the data: ");
                        data = scan.nextInt();
                        sll.insertAtEnd(data);
                    }
                    case 4 -> sll.deleteFromBeginning();
                    case 5 -> {
                        System.out.print("Enter the position: ");
                        position = scan.nextInt();
                        sll.deleteFromPosition(position);
                    }
                    case 6 -> sll.deleteFromEnd();
                    case 7 -> sll.displayList();
                    case 8 -> {
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