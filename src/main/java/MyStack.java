public class MyStack implements Stackable {

    private static class Node {
        Object element;
        Node next;

        public Node(Object element) {
            this.element = element;
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

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.printStack();
        myStack.printHead();
    }



    @Override
    public void push(Object element) {

        if(isFull()){
            System.out.println("Stack is full");
            return;
        }

        Node node = new Node(element);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
    }


    @Override
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Object element = head.element;
        head = head.next;
        size--;
        return element;
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



