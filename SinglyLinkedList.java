package Assignments;

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtStart('a');
        linkedList.insertAtStart('b');
        linkedList.insertAtStart('c');
        linkedList.insertAtStart('d');
        linkedList.insertAtStart('e');
        linkedList.insertAtStart('f');
        linkedList.insertAtStart('g');
        linkedList.printList();
        System.out.println(linkedList.indexOf('g'));
    }
}

class LinkedList {
    Node head;

    class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtStart(char data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public String getFirst() {
        if (head == null) {
            return "The list is empty!";
        }
        return "Data at the start of list is : " +head.data;
    }

    public char getLast() {
        Node n = head;
        char data = ' ';
        while (n != null) {
            data = n.data;
            n = n.next;
        }
        return data;
    }

    public void delete(int index) {
        Node node = head;
        if (index == 1) {
            head = node.next;
            return;
        }
        int i = 1;
        while (i < index-1) {
            node = node.next;
            i++;
        }
        Node temp = node;
        temp = temp.next;
        node.next = temp.next;
    }

    public String indexOf(char data) {
        Node n = head;
        int index = 1;
        while (!(n.data == data)) {
            if(n.next == null) {
                return "Given data doesn't exist in the list";
            }
            n = n.next;
            index++;
        }
        return "The index of " + data + " is : " +index;
    }

    public void insertAtIndex(char data, int index) {
        Node node = head;
        if(index == 1) {
            insertAtStart(data);
            return;
        }


    }

}
