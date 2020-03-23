/*
 * Name:        Prarthana Sarpal
 * Version:     1.02
 * Date:        May 15th, 2019
 * Description: Client for LinkedList object + test code
 */

package LinkedList;

/**
 *
 * @author prarthanasarpal
 */

public class LinkedListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        System.out.println("LINKED LISTS TEST CASES");
        System.out.println("-----------------------");
        
        System.out.println("Check EMPTY list");
        assert(list.isEmpty() == true);
        assert(list.isFull() == false);
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.tail() == null);
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");

        
        System.out.println("Check with ONE entry");
        list.addAtFront("ABC");
        
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 1);
        assert(list.head().equals("ABC"));
        assert(list.tail().equals("ABC"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        
        System.out.println("Check with TWO entries");
        list.addAtEnd("123");
        
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 2);
        assert(list.head().equals("ABC"));
        assert(list.tail().equals("123"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check with THREE entries");
        list.addAtEnd("XYZ");
        
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 3);
        assert(list.head().equals("ABC"));
        assert(list.tail().equals("XYZ"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        
        System.out.println("Check with FOUR entries");
        list.addAtFront("A");
        
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 4);
        assert(list.head().equals("A"));
        assert(list.tail().equals("XYZ"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Remove TAIL");
        list.removeTail();
        
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 3);
        assert(list.head().equals("A"));
        assert(list.tail().equals("123"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Remove HEAD");
        list.removeHead();
        assert(list.isEmpty() == false);
        assert(list.isFull() == false);
        assert(list.size() == 2);
        assert(list.head().equals("ABC"));
        assert(list.tail().equals("123"));
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********"); 
        
        list.makeEmpty();
        
        System.out.println("Checking REMOVE");
        // add alphabet to list
        for (int i = 65, size = 1; i < 91; i++, size++) {
            list.addAtEnd(Character.toString((char)i));

            assert (list.capacity() == Integer.MAX_VALUE);
            assert (list.isEmpty() == false);
            assert (list.tail().equals(Character.toString((char)i)));
            assert (list.head().equals("A"));
            assert (list.size() == size);  
        }
        
        System.out.println(list.toString());
        assert(list.size() == 26);
        assert(list.tail().equals("Z"));
        
        list.remove("XA");
        list.remove("B");
        list.remove("A");
        list.remove("Z");
        
        assert(list.size() == 23);
        assert(list.head().equals("C"));
        assert(list.tail().equals("Y"));
        System.out.println(list.toString());
        System.out.println("PASSED");
        System.out.println("**********"); 
        
        System.out.println("Check MAKE EMPTY");
        list.makeEmpty();
        
        assert(list.isEmpty() == true);
        assert(list.isFull() == false);
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.tail() == null);
        assert(list.capacity() == Integer.MAX_VALUE);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("ALL CASES PASSED");
        
        // WORK ON REMOVE
    }
    
}