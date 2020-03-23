/*
 * Name:        Prarthana Sarpal
 * Version:     1.01
 * Date:        May 15th, 2019
 * Description: Node object 
 */

package LinkedList;

/**
 * TODO
 */
public class Node implements NodeInterface {

    Node nextNode;
    private String value;
    
    public Node() {
        this(null);
    }
    
    public Node(String value) {
        this.value = value;
    }
    
    public Node getNext() {       
        return nextNode;
    }
    
    public void setNext(Node newNode) {
        this.nextNode = newNode;
    }
    
    public String getValue() {
        return this.value;
    }
}