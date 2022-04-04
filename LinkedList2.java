public class LinkedList2 {
    public int data; //data stored in current
    public LinkedList2 next; //pointer to next

    //constructor
    public LinkedList2(int data){
        this.data = data;
        this.next=null;
    }
}

class LL{
    public LinkedList2 head; //creating head

    //constructor
    public LL(){
        this.head = null;
    }

    public void addNode(int data){
        LinkedList2 node = new LinkedList2(data);

        //if there is nothing in the linked list, head = node
        if(this.head == null){
            this.head = node;
        }
        else{
            LinkedList2 temp = this.head;

            //iterate to find end of linkedlist (where the last node is
            while(temp.next != null){
                temp = temp.next;
            }
            //change node at last position to be node
            temp.next = node;
        }
    }

    public void swapData(LinkedList2 a, LinkedList2 b){
        //very simple swap
        int temp = a.data;
        a.data = b.data;
        b.data = a.data;
    }

    public void BubbleSort(){
        if(head != null){ //if linkedlist is not empty then:
            LinkedList2 current = null;
            boolean status = false;

            do {
                current = this.head; //start current on first node
                status = false;//resets status for loop

                while (current != null && current.next != null) { //while there are values in the

                    //swap values if left is greater than right
                    if (current.data > current.next.data) {
                        int temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;

                        status=true; //set status to true when node changes value
                    }
                    current = current.next; //increments so we move on to next node
                }
            }
            while(status);
        }
        else{
            System.out.println("Empty linkedlist");
        }
    }

    //actual sorting function
    public void selectionSort(){
        LinkedList2 mainList = this.head;
        LinkedList2 temp = null;
        LinkedList2 node = null;

        /*how to do selection sort
        selection sort has "sorted" & "unsorted"
        selection sort while go through entire linkedlist and find the lowest node, and put that in the front
        it will keep doing this until the unsorted list is completely sorted
         */
        while (mainList != null){
            node = mainList;
            temp = mainList.next;

            //find minimum node in list
            while (temp != null){ //as long as there is stuff in the list
                if (node.data > temp.data){ //if first value is greater than 2nd value
                    node = temp;
                }
                temp = temp.next; //go to next node
            }//essentially this function sets node to the lowest value in the unsorted linkedlist
            if(mainList.data > node.data){
                //transfer minimum value to initial position
                swapData(mainList, node);//swaps node value
            }
            mainList = mainList.next; //goes to next node
        }
    }

    public void printLinkedList(){
        if(this.head == null){
            System.out.println("Linked list is empty\n");
            return;
        }
        LinkedList2 temp = this.head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("-> NULL\n"); //essentially, reached end of linkedlist
    }

    public static void main(String args[]){
        LL linkedlist = new LL();

        int SIZE = 25;
        linkedlist.addNode(25);
        linkedlist.addNode(18);
        linkedlist.addNode(13);
        linkedlist.addNode(35);
        linkedlist.addNode(16);
        linkedlist.addNode(35);

        System.out.print("\nLinked List before sorting: ");
        linkedlist.printLinkedList();

        linkedlist.BubbleSort();
        System.out.print("\n linkedlist after sorting: ");
        linkedlist.printLinkedList();


    }

}
