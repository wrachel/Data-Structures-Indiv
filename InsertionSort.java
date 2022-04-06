import java.util.ArrayList;
/*
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
*/
public class InsertionSort extends Sorts{
    private ArrayList<Integer> FinalArr;
    private int comparisons;
    private int swaps;

    public InsertionSort(int size) {
        super(size);
    }

    //added constructor that calls super class with a parameter of an Array List of integers
    public InsertionSort(ArrayList<Integer> arr) { super(arr); }

    public void sort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 1; i < n; ++i) { //iterate from arr[1] to arr[n]
            Integer key = arr.get(i); //assigns current element to a "key"
            int j = i - 1;

            // Move elements of arr[0..i-1] greater than key to one position ahead of current position
            while (j >= 0 && arr.get(j) > key) {
                //if arr[i - 1] is greater than arr[i] then set i to i-1 and i-1 to i (essentially flip them)
                arr.set(j + 1, arr.get(j));
                j = j - 1;
                swaps++;
                comparisons++;
            }
            arr.set(j + 1, key); //sets arr at i-1 to i
            comparisons++;
        }

        FinalArr = arr;
    }

    public String toString(){
        String returnStatement = "";
        for(Integer a : FinalArr){
            returnStatement += a + " ";
        }
        String s = "Sorted Array: " + returnStatement + "\n" + "Time Elapsed: " + getTimeElapsed() + " nanoseconds" + "\n";
        return s;
    }
    public int getComparisons(){
        return this.comparisons;
    }
    public int getSwaps(){
        return this.swaps;
    }
    public ArrayList<Integer> getFinalArr() { return FinalArr;}
    // Driver method
    public static void main(String args[])
    {

        ArrayList<Integer> times = new ArrayList<Integer>();

        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i = 0; i < TIMES; i ++) {

            //create new instance of InsertionSort
            InsertionSort a = new InsertionSort(SIZE);
            ArrayList<Integer> arr = a.getData(); //assigns data from sort to arr
            a.sort(arr); //sorts data in array

            System.out.print(a.toString());

            times.add(a.getTimeElapsed());
        }
        //add times to the sum
        for(Integer a : times){
            sum += a;
        }
        double averageTime = sum / TIMES; //divide sum by TIMES to get average time
        System.out.println("average time: " + averageTime + "nanoseconds");
    }

}
