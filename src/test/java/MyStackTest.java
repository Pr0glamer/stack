import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void push() throws MyStack.StackIsFullException {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        assertEquals(myStack.size(), 1);
    }

    @Test
    public void pop() throws MyStack.StackIsFullException, MyStack.StackIsEmptyException {
        MyStack myStack = new MyStack(4);
        int element = 1;
        myStack.push(element);
        int popped = (int)myStack.pop();
        assertEquals(popped, element);
    }

    @Test
    public void whenPopElement_ReturnsOptional() throws MyStack.StackIsFullException, MyStack.StackIsEmptyException {
        MyStack myStack = new MyStack(4);
        int element = 1;
        myStack.push(element);
        var popped = myStack.pop_element();
        assertEquals(popped.get(), element);
    }

    @Test
    public void size() throws MyStack.StackIsFullException {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);
        myStack.push(1);
        assertEquals(myStack.size(), 4);
    }

    @Test
    public void isEmpty() throws MyStack.StackIsFullException, MyStack.StackIsEmptyException {
        MyStack myStack = new MyStack(1);
        myStack.push(1);
        assertFalse(myStack.isEmpty());
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void isFull() throws MyStack.StackIsFullException, MyStack.StackIsEmptyException {
        MyStack myStack = new MyStack(1);
        myStack.push(1);
        assertTrue(myStack.isFull());
        myStack.pop();
        assertFalse(myStack.isFull());
    }

    @Test
    public void whenStackIsFull_thenThrowException() {

        MyStack myStack = new MyStack(1);

        Exception exception = assertThrows(MyStack.StackIsFullException.class, () -> {
            myStack.push(1);
            myStack.push(1);
        });

        String expectedMessage = "Stack if full";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void whenStackIsEmpty_thenThrowException() {

        MyStack myStack = new MyStack(1);

        Exception exception = assertThrows(MyStack.StackIsEmptyException.class, () -> {
            myStack.pop();
        });

        String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}