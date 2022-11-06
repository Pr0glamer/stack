import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void push() {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        assertEquals(myStack.size(), 1);
    }

    @Test
    public void pop() {
        MyStack myStack = new MyStack(4);
        int element = 1;
        myStack.push(element);
        int popped = (int)myStack.pop();
        assertEquals(popped, element);
    }

    @Test
    public void size() {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);
        assertEquals(myStack.size(), 4);
    }

    @Test
    public void isEmpty() {
        MyStack myStack = new MyStack(1);
        myStack.push(1);
        assertFalse(myStack.isEmpty());
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void isFull() {
        MyStack myStack = new MyStack(1);
        myStack.push(1);
        assertTrue(myStack.isFull());
        myStack.pop();
        assertFalse(myStack.isFull());
    }
}