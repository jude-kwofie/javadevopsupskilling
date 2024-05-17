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
    public void prepend(int value){
        //create a link
        Node lk = new Node(value);

        // point it to old first node
        lk.next = head;
        if(head == null){
            tail=lk;
        }
        //point first to new first node
        head = lk;


    }
    public void  insertByIndex(int index, int value){
        Node p = head;
        Node prev = head;
        Node lk = new Node(value);

        int counter = 0;

        //start from the beginning
        while(p != null ) {


            if(index == 0){
                lk.next = head;
                head = lk;
                return;
            }
            else if(counter == index ){
                lk.next = p;
                prev.next =lk;
               return;
            }

            counter++;
            prev = p;
            p = p.next;
        }
        System.out.println(counter);
        if(counter == index){
            System.out.println(tail.data);
            this.tail.next = lk;
            this.tail = lk;
        }else {
            System.out.println("List out Bound");
        }
    }

    public void append(int value){
        //create a link
        Node lk = new Node(value);
        // point the tail node not new node
        tail.next=lk;
        //point tail node to new node
        tail = lk;
    }

    public  void remove(int value){
        Node p = head;
        Node prev = head;
        
        if(p.data == value){
            head = p.next;
            return;
        }

        //start from the beginning
        while(p != null ) {
            if(p.data==value ){
                prev.next = p.next;
                return;
            }
            prev =p;
            p = p.next;
        }
    }
    public boolean search(int value){
        Node p = head;
        //start from the beginning
        while(p != null ) {
            if(p.data==value){
                return true;
            }
            p = p.next;
        }
        return false;
    }


    public void printList() {
        Node p = head;
        System.out.print("\n[");

        //start from the beginning
        while(p != null) {
            System.out.print(" " + p.data + " ");
            p = p.next;
        }
        System.out.print("]");
    }

}
