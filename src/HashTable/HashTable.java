/*
 * Name:        Prarthana Sarpal
 * Version:     1.04
 * Date:        May 19th, 2019
 * Description: Hash Table object 
 */

package HashTable;

/**
 *
 * @author prarthanasarpal
 */

public class HashTable implements HashTableInterface {

    private int capacity;
    private Student s;
    protected Student[] table;

    public HashTable(int capacity) {
        // check capacity
        if (isPrime(capacity)) {
            this.capacity = capacity;
        } else {
            this.capacity = nextPrime(capacity);
        }
        this.table = new Student[this.capacity];
    }

    private Boolean isPrime(int capacity) {
        for (int i = 2; i < (capacity + 1 / 2); i++) {
            if (capacity % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int nextPrime(int capacity) {
        int n = capacity;

        do {
            n = n + 1;
        } while (!isPrime(n));
        return n;

    }

    public boolean isEmpty() {
        for (int i = 0; i < this.capacity; i++) {
            if (table[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        if (size() == this.capacity) {
            return true;
        }
        return false;
    }

    public void makeEmpty() {
        for (int i = 0; i < this.capacity; i++) {
            table[i] = null;
        }
    }

    public int size() {
        int size = 0;

        for (int i = 0; i < this.capacity; i++) {
            if (table[i] != null) {
                size++;
            }
        }

        return size;
    }

    public void put(int key, Student value) {
        int collisions = 0;
        int index = hash(key);
        
        // check load factor
        rehash();

        if (key != 0 && value != null && !isFull() && (!this.contains(value) || !this.containsKey(key))) {
            //int index = hash(key);
            if (table[index] == null) {
                table[index] = value;
            }
            else {
                // linear probe           
                while (this.table[index % this.capacity] != null) {
                    index++;        // adds index while index is full
                    collisions++;
                }
                this.table[index % this.capacity] = value;      // sets value to next empty spot
            } 
        }
        if(collisions > 0) {
        System.out.println("Collisions: " + collisions);
        }
    }

    // returns the index of the nexf empty spot
    private int linearProbe(int key) {
        int index = hash(key);

        if (index < (size() - 1)) {
            while (table[index % capacity] != null) {
                index = index + 1;
            }
        } else if (table[index] != null && index == (size() - 1)) {
            index = 0;
            System.out.println("2ND LOOP");
            while (table[index] != null) {
                index = index + 1;
            }
        }

        return index;
    }

    public Student get(int key) {
        if (!isEmpty()) {
            for (int i = 0; i < this.capacity; i++) {
                if (table[i] != null) {
                    if (table[i].getPrimaryKey() == key) {
                        // if found, return student at i
                        return table[i];
                    }
                }
            }
        }
        // else return null

        return null;
    }

    // Tests if the specified object is a key in this hashtable.
    public boolean containsKey(int key) {
        if (!isEmpty()) {
            for (int i = 0; i < this.capacity; i++) {
                if (table[i] != null) {
                    if (table[i].getPrimaryKey() == key) {
                        // if key found, return true
                        return true;
                    }
                }
            }
        }
        // else return false
        return false;
    }

    // Tests if a SECONDARY KEY of the value maps into the specified value in this hashtable.
    public boolean contains(Student value) {
        if (!isEmpty()) {
            for (int i = 0; i < this.capacity; i++) {
                if (table[i] != null) {
                    // check firstName
                    if (table[i].getFirstName().equals(value.getFirstName())) {
                        // check lastName
                        if (table[i].getLastName().equals(value.getLastName())) {
                            // check DOB
                            if (table[i].getDOB().equals(value.getDOB())) {
                                // if ALL found, retrun true
                                return true;
                            }
                        }
                    }
                }
            }
        }
        // else return false
        return false;
    }

    public int hash(int primaryKey) {
        String pK = "";
        pK = Integer.toString(primaryKey);
        // uses last 5 digits
        pK = pK.substring(1);

        primaryKey = Integer.parseInt(pK);

        return primaryKey % this.capacity;
    }

    // Increases the capacity of and internally reorganizes this hashtable, in
    // order to accommodate and access its entries more efficiently.
    public void rehash() {
        int oldCapacity = this.capacity;
        double loadFactor = 0.25;
        String s = "";
        //int cap;

        if (loadFactor() >= 75) {
            // resize capacity so loafcator is 25% 

            // copy cat array 
            Student[] copyCatTable = new Student[this.capacity];
            copyCatTable = this.table;

            // new capacity = size / 0.25
            // 0.25 = loadFactor wanted / 100
            this.capacity = (int) Math.round(size() / loadFactor);

            // change array length
            this.table = new Student[this.capacity];

            // move objects around from copy of old table to the table with new capacity
            for (int i = 0; i < oldCapacity; i++) {
                if (copyCatTable[i] != null) {
                    put(copyCatTable[i].getPrimaryKey(), copyCatTable[i]);
                }
            }
        }
    }

    public double loadFactor() {
        double cap = this.capacity;
        double loadFactor = (this.size() / cap) * 100;
        return loadFactor;
    }

    public String toString() {
        String s = "";

        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                s = s + " " + null + " ";
            } else {
                s = s + " " + Integer.toString(table[i].getPrimaryKey()) + "";
            }
        }

        return s;
    }

}