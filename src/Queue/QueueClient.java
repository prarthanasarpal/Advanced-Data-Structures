/*
 * Name:        Prarthana Sarpal
 * Version:     1.04
 * Date:        May 15th, 2019
 * Description: Client for Queue object + test code
 */

package Queue;

/**
 *
 * @author prarthanasarpal
 */

public class QueueClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue queue = new Queue();
        System.out.println("QUEUE TEST CASES");
        System.out.println("----------------");
        
        System.out.println("Check EMPTY Queue");
        // check empty queue
        assert (queue.capacity() == 11);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);
        assert (queue.tail() == null);
        assert (queue.head() == null);
        assert (queue.dequeue() == null);
        assert (queue.size() == 0);

        System.out.println("PASSED");
        System.out.println("**********");

        System.out.println("Check With ONE entry");
        // check queue with ONE entry
        queue.enqueue("A");
        
        assert (queue.capacity() == 11);
        assert (queue.isEmpty() == false);
        assert (queue.isFull() == false);
        assert (queue.tail().equals("A"));
        assert (queue.head().equals("A"));
        assert (queue.size() == 1);       
        assert (queue.dequeue().equals("A"));
        
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Fill Queue and Check FULL Queue");
        // fill queue
        for (int i = 65, size = 1; i < queue.capacity() + 65; i++, size++) {
            queue.enqueue(String.valueOf((char) i));

            assert (queue.capacity() == 11);
            assert (queue.isEmpty() == false);
            assert (queue.tail().equals(Character.toString((char)i)));
            assert (queue.head().equals("A"));
            assert (queue.size() == size);  
            
            //queue.toString();
            //System.out.println("");
        }
        
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("OVERFILL Queue");       
        // overfill 
        queue.enqueue("L");
        assert (queue.isFull() == true);
        assert (queue.tail().equals("K"));
        assert (queue.head().equals("A"));
          
        System.out.println("PASSED");
        System.out.println("**********");
              
        System.out.println("Empty Queue and Recheck EMPTY Queue");
        // empty queue
        for (int i = queue.capacity() + 64, size = 11, head = 65; size > 0; i--, size--, head++) {
            assert (queue.capacity() == 11);
            assert (queue.head().equals(Character.toString((char)head)));
            assert (queue.size() == size);
            assert (queue.tail().equals("K"));
            
            queue.dequeue();
        }
        
        assert (queue.capacity() == 11);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);        
        assert (queue.size() == 0); 
        System.out.println("PASSED");
        System.out.println("**********");
        
        System.out.println("Check makeEmpty()");
        // check makeEmpty()
        queue.enqueue("A");
        
        queue.makeEmpty();
        assert (queue.capacity() == 11);
        assert (queue.isEmpty() == true);
        assert (queue.isFull() == false);
        assert (queue.tail() == null);
        assert (queue.head() == null);
        assert (queue.dequeue() == null);
        assert (queue.size() == 0);       
        System.out.println("PASSED");
        System.out.println("**********"); 
        
        System.out.println("Check if queue is CIRCULAR");
        // fill queue up again
        for (int i = 65, size = 1; i < queue.capacity() + 65; i++, size++) {
            queue.enqueue(String.valueOf((char) i));
            
            assert (queue.capacity() == 11);
            assert (queue.isEmpty() == false);
            assert (queue.tail().equals(Character.toString((char)i)));
            assert (queue.head().equals("A"));
            assert (queue.size() == size);  
        }
        
        // dequeue head twice
        queue.dequeue();
        queue.dequeue();
       
        assert(queue.size() == 9);
        assert(queue.capacity() == 11);
        assert(queue.isFull() == false);
        assert(queue.isEmpty() == false);
        assert(queue.head().equals("C"));
        
        
        queue.enqueue("1");
        assert(queue.size() == 10);
        assert(queue.tail().equals("1"));
        
        queue.enqueue("2");
        assert(queue.size() == 11);
        assert(queue.tail().equals("2"));
        assert(queue.isFull() == true);
        assert(queue.isEmpty() == false);
         
        System.out.println("PASSED");
        System.out.println("**********");
       
        System.out.println("ALL CASES PASSED");
    }

}