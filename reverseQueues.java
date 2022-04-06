import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;

public class reverseQueues {

    //method to first sort the queue using an insertion sort
    public static void sort(Queue<Integer> initQueue) {
        //initialize arrayList of integers
        ArrayList<Integer> arrayList = new ArrayList<>();

        //pull each element from the inputted queue and add each to the arrayList
        while (!initQueue.isEmpty()) {
            arrayList.add(initQueue.poll());
        }
        //run an insertion sort on the arrayList created from the queue
        InsertionSort sort = new InsertionSort(arrayList);
        //get sorted array
        arrayList = sort.getFinalArr();
        //add each element from the now sorted arrayList back to the queue in the new, sorted order
        for (Integer i : arrayList) {
            initQueue.add(i);
        }
        //print the sorted queue
        System.out.println(initQueue);
    }

    public static void reverse(Queue<Integer> initQueue){
        /**
         * In order to reverse the Queue into a stack, you need to make a temporary/empty stack
         * Then, reverse the queue order by popping the elements from the stack and put the elements into the queue into the stack
         * Push the elements back into the Queue & print elements in the queue
         */
        Stack temp = new Stack(); //creates a temporary stack
        //new stack is now created as an object from the custom Stack class rather than the imported one

        //pushes element from queue to stack
        while(!initQueue.isEmpty()){
            temp.push(initQueue.poll());
        }

        //pop elements from stack to Queue
        while(!temp.isEmpty())
        {
            initQueue.add((Integer)temp.pop());
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
        queue1.add(10);
        queue1.add(4);
        System.out.println("Initial Queue: "+ queue1);

        //run method to sort queue1
        System.out.print("Sorted Queue: ");
        sort(queue1);

        System.out.print("Reverse Queue: ");
        reverse(queue1);
    }
}
