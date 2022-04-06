public class Stack {
    //lifo Object of stack
    private LinkedList node;

    //constructor to create empty list
    public Stack() {
        node = null;
    }

    //new object is pushed to top of Stack
    public void push(Object value) {
        //new object becomes current + gets value and current lifo is as assigned as previous node
        node = new LinkedList(value, node);
    }

    //pops object from top of Stack
    public Object pop() {
        Object value = null;

        if (node != null) {
            //value of popped object is returned
            value = node.getData();
            //the previous node is set to the new lifo
            node = node.getPrevious();
        }

        return value;
    }

    //returns stack as a String representation
    public String toString() {
        StringBuilder stack = new StringBuilder("[");

        //start from lifo (last in)
        LinkedList n = node;
        //loop until get to beginning of stack
        while (n != null) {
            //return data at current node and append to string
            stack.append(n.getData());
            //move to previous node
            n = n.getPrevious();
            if (n != null)
                stack.append(", ");
        }
        stack.append("]");
        return stack.toString();
    }

    //check lifo to return whether Stack is empty or not
    public boolean isEmpty() {
        return (this.node == null);
    }
}
