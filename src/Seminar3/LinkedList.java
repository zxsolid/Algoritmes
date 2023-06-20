package Seminar3;

public class LinkedList {
    Node head;
    Node tail;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            node.next.previous = null;
            head = next;
        } else if (next == null) {
            node.previous.next = null;
            tail = previous;
        } else {
            previous.next = next;
            next.previous = previous;
        }
    }

    public int getSize() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void revers() {
        //если у нас пустой список или список из одного элемента, то нет смысла делать реверс
        if (head == null || head.next == null) return;

        Node currentNode = head;
        Node next;
        while (currentNode != null) {
            next = currentNode.next;
            currentNode.next = currentNode.previous;
            currentNode.previous = next;
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node curentNode = head;
        while (curentNode != null) {
            result.append(curentNode.value);
            if (curentNode.next != null) result.append(',');
            curentNode = curentNode.next;
        }

        return result.append(']').toString();
    }

    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
}
