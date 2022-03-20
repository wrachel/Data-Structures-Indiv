import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueues {

    public static void reverse(Queue<Integer> initQueue){
        /**
         * In order to reverse the Queue into a stack, you need to make a temporary/empty stack
         * Then, reverse the queue order by popping the elements from the stack and put the elements into the queue into the stack
         * Push the elements back into the Queue & print elements in the queue
         */
        Stack<Integer> temp = new Stack<>(); //creates a temporary stack

        //pushes element from queue to stack
        while(!initQueue.isEmpty()){
            temp.push(initQueue.poll());
        }

        //pop elements from stack to Queue
        while(!temp.isEmpty())
        {
            initQueue.add(temp.pop());
        }

        //print values from queue
        for(Integer value2: initQueue) {
            System.out.print(value2 + " -> ");
        }
        System.out.print("nil");


    }

    public static void main(String[] args){
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println("Initial Queue: "+ queue1);

        System.out.print("Reverse Queue: ");
        reverse(queue1);
    }
}
