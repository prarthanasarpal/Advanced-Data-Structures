/**
 * Stack Interface.
 *
 * @author Wm.Muir
 * @version 2018-19.S2
 */

package Stack;

public interface StackInterface {

    public String peek();

    public String pop();

    public void push( String value );

    public int size();

    public int capacity();

    public boolean isEmpty();

    public boolean isFull();

    public void makeEmpty();

}