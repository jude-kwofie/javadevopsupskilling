package com.jude.linkedlist;

/**
 * The ILinkedList class implements a singly linked list.
 * It provides methods to prepend, append, insert by index,
 * remove, search, and print elements of the list.
 *
 * This class uses an inner static Node class to represent
 * the elements of the linked list.
 *
 * Usage example:
 * <pre>
 *     ILinkedList list = new ILinkedList();
 *     list.append(10);
 *     list.prepend(5);
 *     list.insertByIndex(1, 7);
 *     list.printList();
 *     list.remove(7);
 *     boolean found = list.search(10);
 * </pre>
 *
 * @since 1.0
 */
public class ILinkedList {

    Node head;
    Node tail;

    /**
     * A static inner class representing a node in the linked list.
     */
    static class Node {
        int data;
        Node next;

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the value to be stored in the node
         */
        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }
    /**
     * Prepends a new node with the given value to the start of the list.
     *
     * @param value The value to be added to the list.
     */
    public void prepend(int value) {
        // Create a link
        Node lk = new Node(value);

        // Point it to old first node
        lk.next = head;
        if (head == null) {
            tail = lk;
        }
        // Point first to new first node
        head = lk;
    }

    /**
     * Inserts a new node with the given value at the specified index in the list.
     *
     * @param index The index where the new node should be inserted.
     * @param value The value to be added to the list.
     */
    public void insertByIndex(int index, int value) {
        Node p = head;
        Node prev = head;
        Node lk = new Node(value);
        int counter = 0;

        // Start from the beginning
        while (p != null) {
            if (index == 0) {
                lk.next = head;
                head = lk;
                return;
            } else if (counter == index) {
                lk.next = p;
                prev.next = lk;
                return;
            }

            counter++;
            prev = p;
            p = p.next;
        }

        if (counter == index) {
            this.tail.next = lk;
            this.tail = lk;
        } else {
            System.out.println("List out of bounds");
        }
    }

    /**
     * Appends a new node with the given value to the end of the list.
     *
     * @param value The value to be added to the list.
     */
    public void append(int value) {
        // Create a link
        Node lk = new Node(value);
        // Point the tail node to the new node
        if (tail != null) {
            tail.next = lk;
        }
        // Point tail to new node
        tail = lk;
        if (head == null) {
            head = lk;
        }
    }

    /**
     * Removes the first node with the specified value from the list.
     *
     * @param value The value of the node to be removed.
     */
    public void remove(int value) {
        Node p = head;
        Node prev = head;

        if (p != null && p.data == value) {
            head = p.next;
            return;
        }

        // Start from the beginning
        while (p != null) {
            if (p.data == value) {
                prev.next = p.next;
                return;
            }
            prev = p;
            p = p.next;
        }
    }

    /**
     * Searches for a node with the given value in the list.
     *
     * @param value The value to search for in the list.
     * @return true if the value is found, false otherwise.
     */
    public boolean search(int value) {
        Node p = head;
        // Start from the beginning
        while (p != null) {
            if (p.data == value) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * Prints the elements of the list.
     */
    public void printList() {
        Node p = head;
        System.out.print("\n[");

        // Start from the beginning
        while (p != null) {
            System.out.print(" " + p.data + " ");
            p = p.next;
        }
        System.out.print("]");
    }


}
