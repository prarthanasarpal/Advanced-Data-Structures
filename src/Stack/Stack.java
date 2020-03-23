/*
 * Name:        Prarthana Sarpal
 * Version:     1.03
 * Date:        May 15th, 2019
 * Description: Stack object 
 */

package Stack;

/**
 *
 * @author prarthanasarpal
 */

public class Stack implements StackInterface {

    // CONSTANTS
    private static final int DEF_CAP = 11;

    // VARIABLES
    private int top;
    private int capacity;
    private String[] stacks;

    public Stack() {
        // set to default settings
        this(DEF_CAP);
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stacks = new String[capacity];
        this.top = -1;
        //this.size = 0;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isFull() {
        if ((top + 1) == capacity) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if ((this.top + 1) == 0) {
            return true;
        }
        return false;
    }

    // returns value at top
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return stacks[this.top];
    }

    // adds to TOP of stack
    public void push(String value) {
        if (isFull()) {
            System.out.println("Stack Full");
        } else if (value == null) {
            System.out.println("Can't add Null to Stack");
        } else {
            this.top++;
            stacks[this.top] = value;
        }
    }

    // removes AND returns TOP of stack
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        this.top--;
        return stacks[top + 1];
    }

    // resets stack index
    public void makeEmpty() {
        top = -1;
    }

}