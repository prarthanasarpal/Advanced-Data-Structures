/*
 * Name:        Prarthana Sarpal
 * Version:     1.03
 * Date:        May 15th, 2019
 * Description: Client for the Stack object + test code
 */

package Stack;

/**
 *
 * @author prarthanasarpal
 */

public class StacksClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Stack stack = new Stack();
        System.out.println("STACK TEST CASES");
        System.out.println("----------------");  
        
        System.out.println("Check EMPTY stack");
        assert(stack.capacity() == 11);
        assert(stack.isEmpty() == true);
        assert(stack.isFull() == false);
        assert(stack.peek() == null);
        assert(stack.pop() == null);
        assert(stack.size() == 0);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check with ONE entry");
        stack.push("Hi");
        
        assert(stack.peek().equals("Hi"));
        assert(stack.capacity() == 11);
        assert(stack.isEmpty() == false);
        assert(stack.isFull() == false);
        assert(stack.size() == 1);
        System.out.println("PASSED");
        System.out.println("**********");
        
        // remepty stack
        stack.makeEmpty();
        assert(stack.size() == 0);
        
        System.out.println("Fill Stack and Check FULL Stack");
        // fill queue
        for (int i = 65, size = 1; i < stack.capacity() + 65; i++, size++) {
            stack.push(String.valueOf((char) i));

            assert (stack.capacity() == 11);
            assert (stack.isEmpty() == false);
            assert (stack.peek().equals(Character.toString((char)i)));
            assert (stack.size() == size);  
        }
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("OVERFILL Stack");       
        stack.push("G");
        
        assert (stack.isFull() == true);
        assert (stack.peek().equals("K"));
        assert(stack.size() == 11);
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Empty Stack and Recheck EMPTY Stack");
        for (int i = stack.capacity() + 64, size = 11; size > 0; i--, size--) {
            assert (stack.capacity() == 11);
            assert (stack.size() == size);
            
            //stack.pop();
            assert (stack.pop().equals(Character.toString((char)i)));
        }
        
        assert (stack.capacity() == 11);
        assert (stack.isEmpty() == true);
        assert (stack.isFull() == false);        
        assert (stack.size() == 0);  
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("ALL CASES PASSED");
    }
    
}