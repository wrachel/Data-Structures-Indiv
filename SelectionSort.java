
//selection sort finds the lowest value in the array, and continues doing that until it is sorted

import java.util.ArrayList;

public class SelectionSort extends Sorts{

    public SelectionSort(int size) {
        super(size);
    }

    void SelectionSort(ArrayList<Integer> arr)
    {
        Integer n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }
    // Prints the array
    void printArray(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i)
            System.out.print(arr.get(i) +" ");
        System.out.println();
        System.out.println("Selection Sort Time Elapsed: " + getTimeElapsed() + " nanoseconds");
    }

    public static void main(String args[])
    {
        ArrayList <Integer> times = new ArrayList<Integer>();

        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i = 0; i < TIMES; i ++) {
            SelectionSort ob = new SelectionSort(SIZE);
            ArrayList<Integer> arr = ob.getData();
            ob.SelectionSort(arr);

            System.out.print("Sorted array: ");
            ob.printArray(arr);

            times.add(ob.getTimeElapsed());
        }
//        for(Integer a : times){
//
//        }
    }
}
