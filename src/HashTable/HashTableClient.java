/*
 * Name:        Prarthana Sarpal
 * Version:     1.03
 * Date:        May 19th, 2019
 * Description: Hash Table client + test code 
 */

package HashTable;

/**
 *
 * @author prarthanasarpal
 */

public class HashTableClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashTable table = new HashTable(7);
        Student value = new Student("P", "S", "17/06/01");  // primary key = 100000
                                                            // mod 0
        
        System.out.println("HASH TABLE TEST CASES");
        System.out.println("---------------------");
        
        System.out.println("Check EMPTY table");
        assert(table.isEmpty() == true);
        assert(table.size() == 0);
        assert(table.loadFactor() == 0.0);
        assert(table.contains(value) == false);
        assert(table.containsKey(value.getPrimaryKey()) == false);
        assert(table.get(value.getPrimaryKey()) == null);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check with ONE student");
        // add ONE student
        table.put(value.getPrimaryKey(), value);
         
        assert(value.getPrimaryKey() == 100000);
        assert(table.isEmpty() == false);
        assert(table.size() == 1);
        assert(table.loadFactor() <= 75);
        assert(table.get(value.getPrimaryKey()).equals(value));
        assert(table.contains(value) == true);
        assert(table.containsKey(value.getPrimaryKey()) == true);
        //System.out.println(table.toString());
        System.out.println("PASSED");
        System.out.println("**********");           
        
        System.out.println("Check with TWO students");
        // add another student
        Student a = new Student("A", "B", "27/08/02");    // Primary key = 100002   
        table.put(a.getPrimaryKey(), a);                  // mod 2
        
        assert(a.getPrimaryKey() == 100002);
        assert(table.isEmpty() == false);
        assert(table.size() == 2);
        assert(table.loadFactor() <= 75);
        assert(table.get(100002).equals(a));
        assert(table.contains(a) == true);
        assert(table.containsKey(a.getPrimaryKey()) == true);
        System.out.println("PASSED");
        System.out.println("**********");
        
        Student b = new Student("C", "D", "27/08/02");      // Primary key = 100004
                                                            // mod 4
        
        Student c = new Student("E", "F", "27/08/02");      // Primary key = 100006
        table.put(c.getPrimaryKey(), c);                    // mod 6
        
        Student d = new Student("G", "H", "27/08/02");      // Primary key = 100008
                                                            // mod 1
        
        Student e = new Student("I", "J", "27/08/02");      // Primary key = 100010
                                                            // mod 3
        
        Student f = new Student("K", "L", "27/08/02");      // Primary key = 100012
                                                            // mod 5
        
        System.out.println("Check COLLISIONS + linear probing");
        System.out.println(table.toString());
        System.out.println("Add a Student object with the same primary key "
                + "to check if linear probing takes place.");
        
        Student g = new Student("M", "N", "27/08/02");      // Primary key = 100014
        table.put(g.getPrimaryKey(), g);                    // mod 0 (DUPLICATE HASH)
        
        System.out.println(table.toString());
        
        Student h = new Student("O", "P", "27/08/02");      // Primary key = 100016
                                                            // mod 2
        Student i = new Student("Q", "R", "27/08/02");      // Primary key = 100018
                                                            // mod 4
        
        System.out.println("Add a Student object with the same primary key as the "
                + "student in the last index to test if index wraps around.");                                                    
        // checks if linear probing wraps around (pick a number with the same 
        // hash number as last array index)
        Student j = new Student("S", "T", "27/08/02");      // Primary key = 100020
        table.put(j.getPrimaryKey(), j);                    // mod 6 (DUPLICATE HASH)
        
        System.out.println(table.toString());        
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check DUPLICATES");
        assert(table.size() == 5);      // size doesn't change bc no new objects added
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check MAKE EMPTY");
        table.makeEmpty();
        assert(table.isEmpty() == true);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("ALL CASES PASSED");
    }
    
}