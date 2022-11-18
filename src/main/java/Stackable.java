import java.util.Optional;

public interface Stackable {

    void push(Object element) throws MyStack.StackIsFullException;

    Object pop() throws MyStack.StackIsEmptyException;

    Optional<Object> pop_element() throws MyStack.StackIsEmptyException;

    int size();

    boolean isEmpty();

    boolean isFull();

}
