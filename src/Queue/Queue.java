/*
 * Name:        Prarthana Sarpal
 * Version:     1.03
 * Date:        May 15th, 2019
 * Description: Queue object 
 */

package Queue;

/**
 *
 * @author prarthanasarpal
 */

public class Queue implements QueueInterface {

    // CONSTANTS
    private static final int DEF_CAP = 11;

    // VARIABLES
    private int head;
    private int tail;
    private int size;
    private int capacity;
    private String[] queue;

    public Queue() {
        // set to default size
        this(DEF_CAP);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.head = -1;
        this.tail = -1;
        this.queue = new String[capacity];
    }

    public int capacity() {
        return this.capacity;
    }

    // returns the value of the head (in front)
    public String head() {
        if (!isEmpty()) {
            return this.queue[this.head];
        }
        return null;
    }

    // returns the value of the head (at back)
    public String tail() {
        if (!isEmpty()) {
            return this.queue[this.tail];
        }
        return null;
    }

    // adds to FRONT of queue
    public void enqueue(String value) {
        if (this.head < 0 && value != null) {
            this.tail = 0;
            this.head = 0;
            this.queue[this.tail] = value;
        } else if(!isFull() && value != null) {
            if(this.tail == queue.length) {
                // tail is pointing at last index
                this.tail = -1;
            }
            this.queue[this.tail + 1] = value;
            tail = tail + 1;
        } 
    }

    // removes from FRONT of queue
    public String dequeue() {
        if (!isEmpty()) {
            if (size() == 1) {
                String value = queue[head];
                this.makeEmpty();
                return value;
            }
            // move head index up by one
            this.head++;
            return this.queue[this.head-1];
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.head == -1) {
            return true;
        }
        return false;
    }
    
    public void makeEmpty() {
        this.head = -1;     // reset head and tail indexes
        this.tail = -1;
    }

    public boolean isFull() {
        if (size() == capacity) {
            return true;
        }
        return false;
    }

    // returns number of objects in queue (CIRCULAR)
    public int size() {
        if (this.head < 0) {        // empty
            return 0;
        } else if (this.head == this.tail) {        // one entry
            size = 1;
            return size;
        } else if (tail > head) {       // tail index > head index
            size = (tail - head) + 1;
            return size;
        } else if (head > tail) {       // head index > tail index (special case)
            int x = this.capacity - this.head;
            //int y = this.tail - 0;
            //size = x + this.tail + 1;
            size = (tail + capacity - head) + 1;
            return size;
        }
        return -1;
    }

    // to string for TESTING purposes (ONLY FORMATS FOR 6 ENTIRES)
    public String toString() {
        for (int i = 0; i < 6; i++) {
            if (i == this.head) {
                if (this.head == this.tail) {
                    queue[i] = "H/T";
                } else {
                    queue[i] = "H";
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            if (i == this.tail) {
                if (this.head == this.tail) {
                    queue[i] = "H/T";
                } else {
                    queue[i] = "T";
                }
            }
        }
        System.out.format("%5s %5s %5s %5s %5s %5s", queue[0], queue[1], queue[2], queue[3], queue[4], queue[5]);
        return null;
    }

}