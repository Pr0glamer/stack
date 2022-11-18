import java.util.Optional;

public class MyStack implements Stackable {

    private static class Node {
        Object element;
        Node next;

        public Node(Object element) {
            this.element = element;
        }

    }

    class StackIsFullException extends Exception {
        public StackIsFullException(String message) {
            super(message);
        }
    }

    class StackIsEmptyException extends Exception {
        public StackIsEmptyException(String message) {
            super(message);
        }
    }


    public MyStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    private Node head;
    private int size = 0;
    private final int MAX_SIZE;


    public void printStack() {
       Node tempHead = head;
       while (tempHead != null) {
           System.out.printf("%3d", tempHead.element);
           tempHead = tempHead.next;
       }
    }

    public static void main(String[] args) throws StackIsFullException {
        MyStack myStack = new MyStack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.printStack();
        myStack.printHead();
    }



    @Override
    public void push(Object element) throws StackIsFullException {

        if(isFull()){
            throw new StackIsFullException("Stack if full");
        }

        Node node = new Node(element);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
    }


    @Override
    public Object pop() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Stack is empty");
        }
        Object element = head.element;
        head = head.next;
        size--;
        return element;
    }

    @Override
    public Optional<Object> pop_element() throws StackIsEmptyException {
        if (isEmpty()) {
            throw new StackIsEmptyException("Stack is empty");
        }
        Object element = head.element;
        head = head.next;
        size--;
        return Optional.of(element);
    }

    public void printHead() {
        System.out.println(head.element);
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

}



