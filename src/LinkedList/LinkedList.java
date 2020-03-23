/*
 * Name:        Prarthana Sarpal
 * Version:     1.03
 * Date:        May 15th, 2019
 * Description: LinkedList object, uses Node object 
 */

package LinkedList;

/**
 *
 * @author prarthanasarpal
 */

public class LinkedList implements LinkedListInterface {

    public Node head;
    public Node tail;

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        if (!isEmpty()) {
            this.head = null;
        }
    }

    public boolean isFull() {
        return false;
    }

    // returns front of list
    public String head() {
        if (!isEmpty()) {
            return this.head.getValue();
        }
        return null;
    }

    // returns end of list
    public String tail() {
        if (!isEmpty()) {
            return this.tail.getValue();
        }
        return null;
    }

    public int size() {
        if (this.head == null) {        // empty
            return 0;
        }
        // else, uses counter to count objects
        int counter = 0;

        Node n = this.head;
        do {
            counter++;
            n = n.getNext();
        } while (n != null);

        return counter;
    }

    public int capacity() {
        return Integer.MAX_VALUE;
    }

    public void addAtFront(String str) {
        if (isEmpty()) {
            Node node = new Node(str);
            node.setNext(null);

            this.head = node;
            this.tail = node;
        } else {
            Node node = new Node(str);      // set value of new node
            node.setNext(this.head);        // link new node to old head node
            this.head = node;       // set head to new node
        }
    }

    public void addAtEnd(String str) {
        if (isEmpty()) {
            // head & tail are the same
            addAtFront(str);
        } else {
            Node node = new Node(str);
            node.setNext(null);     // makes it the end
            // link new node and sever previous node 
            this.tail.setNext(node);    // link old tail node to new tail node
            this.tail = node;       // tail points to new node

        }
    }

    public void remove(String str) {
        int counter = 1;
        Boolean found = false;

        if (str.equals(this.head.getValue())) {
            this.removeHead();
        } else if (str.equals(this.tail.getValue())) {
            this.removeTail();
        } else {
            Node n = this.head;
            //Node toDelete;
                while (counter != this.size() && !(n.getNext().getValue().equals(str))) {
                    // n ends up being the node BEFORE the node to delete
                    counter++;
                    n = n.getNext();
                }
            

            if (counter != size()) {
                Node toDelete = n.getNext();
                n.setNext(n.getNext().getNext()); // link to the node AFTER the one to delete
                toDelete.setNext(null); // Break link to other nodes  
            } else {
                System.out.println("String not found");
            }
        }
    }

    public String removeHead() {
        Node nodeToDelete = this.head;      // remember head node
        this.head = head.getNext();     // set next head
        nodeToDelete.setNext(null);     // disconnect head node

        return nodeToDelete.getValue();
    }

    public String removeTail() {
        Node nodeToDelete = this.tail;      // remember tail node

        // find previous node to set next to null
        Node n = this.head;
        while (n.getNext() != this.tail) {
            n = n.getNext();
        }
        n.setNext(null);        // sever link
        this.tail = n;      // set new tail value

        return nodeToDelete.getValue();
    }

    public String toString() {
        String s = "";
        Node n = this.head;

        for (int i = 0; i < this.size(); i++) {
            s = s + " " + n.getValue() + " ";
            n = n.getNext();
        }
        return s;
    }
}