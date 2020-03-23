package HashTable;

/**
 *
 * @author prarthanasarpal
 */

public class Student {

    //private static int studentID = 0;
    private String firstName;
    private String lastName;
    private String DOB;
    private static int i = 2;
    private int primaryKey = 99998;
    
    // secodnary key constructor- called from Client
    public Student(String firstName, String lastName, String DOB) {
        if (valid(firstName, lastName, DOB)) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.DOB = DOB;
            
            this.primaryKey = this.primaryKey +  this.i;
            this.i = this.i + 2;
        } else {
            System.err.println("Invalid Student");
        }
    }

    private Boolean valid(String firstName, String lastName, String DOB) {
        if (firstName != null && lastName != null && DOB != null) {
            return true;
        }
        return false;
    }
    
    // returns a # divisible by 10 that is 10x greater than the capacity
    // ex. capacity = 53, primaryKey(capacity) = 100;
    private int primaryKey(int capacity) {
        int n = 10;
        while(capacity / 10 > 0) {
            // determines how many digits capacity is and adds ONE more digit
            n = n * 10;
        }
        return n;
    }
    
    public int getPrimaryKey() {
        return this.primaryKey;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public String getDOB() {
        return this.DOB;
    }
}
