import java.util.ArrayList;

/*
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
*/
public class InsertionSort extends Sorts{
    public InsertionSort(int size) {
        super(size);
    }

    void sort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }

    void printArray(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");

        System.out.println("Insertion Sort Time Elapsed:  " + getTimeElapsed() + "nanoseconds");
    }

    // Driver method
    public static void main(String args[])
    {

        ArrayList<Integer> times = new ArrayList<Integer>();

        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i = 0; i < TIMES; i ++) {
            InsertionSort a = new InsertionSort(SIZE);
            ArrayList<Integer> arr = a.getData();
            a.sort(arr);

            System.out.print("Sorted array: ");
            a.printArray(arr);

            times.add(a.getTimeElapsed());
        }
    }

}
