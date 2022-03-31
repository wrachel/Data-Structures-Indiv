
//selection sort finds the lowest value in the array, and continues doing that until it is sorted

import java.util.ArrayList;

public class SelectionSort extends Sorts{

    private ArrayList<Integer> FinalArr;

    public SelectionSort(int size) {
        super(size);
    }

    public void sort(ArrayList<Integer> arr)
    {
        Integer n = arr.size();

        // move boundary of unsorted subarray (thus creating sorted & unsorted subarrays)
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr.get(min_idx) > arr.get(j)) {
                    min_idx = j;
                }
            }
            if(min_idx != i) {
                // Swap the found minimum element with the first element
                int temp = arr.get(i);
                arr.set(i, arr.get(min_idx));
                arr.set(min_idx, temp);
            }
        }
    }

    public String toString(){
        String returnStatement="";
        for (Integer a : FinalArr){
            returnStatement += a + " ";
        }
        String s = "Sorted Array: " + returnStatement + "\n" + "Time Elapsed: " + getTimeElapsed() + " nanoseconds" + "\n";
        return s;
    }


    public static void main(String args[])
    {
        ArrayList <Integer> times = new ArrayList<Integer>(); //create ArrayList to store times

        int sum=0, time=0, TIMES=12, SIZE=5000; //init variables

        for(int i = 0; i < TIMES; i ++) { //create 12 instances
            SelectionSort ob = new SelectionSort(SIZE); //create new SelectionSort instance with 5000 data entries
            ArrayList<Integer> arr = ob.getData(); //use getData() function from parent class; puts data entry into array
            ob.sort(arr); //uses written sort function

            System.out.print(ob.toString());

            times.add(ob.getTimeElapsed()); //add times to the times ArrayList
        }

        //add times to the sum
        for(Integer a : times){
            sum += a;
        }
        double averageTime = sum / TIMES; //divide sum by TIMES to get average time
        System.out.println("average time: " + averageTime + "nanoseconds");
    }
}
