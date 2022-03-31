import java.util.ArrayList;

//compares two entries in the array at a time, and puts lower one down
public class BubbleSort extends Sorts{
    private ArrayList<Integer> FinalArr;

    public BubbleSort(int size) {
        super(size);
    }

    void BubbleSort(ArrayList<Integer> arr){
        int n = arr.size();

        for(int i = 0; i < n -1; i++){ //iterate through the array; needs to compare first two elements, then next two elements, etc.
            for(int j = 0; j < n - i - 1; j++){ //iterates to actually get & swap the two values

                //if value on left is greater than value on right
                if (arr.get(j) > arr.get(j+1)){
                    //swap value on left with value on right
                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
        FinalArr = arr;
    }

    public String toString(){
        String returnStatement ="";
        for (Integer a : FinalArr){
            returnStatement += a + " ";
        }
        String s = "Sorted Array: " + returnStatement + "\n" + "Time Elapsed: " + getTimeElapsed() + " nanoseconds" + "\n";
        return s;
    }


//function to print the Array
    void printArray(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i=0; i<n; ++i) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("Bubble Sort Time Elapsed: "+ getTimeElapsed());
    }

    public static void main(String args[])
    {
        ArrayList <Integer> times = new ArrayList<Integer>();

        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i = 0; i < TIMES; i ++) {

            //createnew instance of Bubble Sort
            BubbleSort sort = new BubbleSort(SIZE);

            //get data & add to an arraylist
            ArrayList<Integer> arr = sort.getData();

            //sort the array using BubbleSort
            sort.BubbleSort(arr);

            System.out.print(sort.toString());

            times.add(sort.getTimeElapsed()); //add times to the times ArrayList
        }

            int smallest;
            int greatest;
            smallest = times.get(0);
            //add times to sum
           for(Integer a : times){
               sum += a;
            }
           double averageTime = sum / TIMES; //divide sum by TIMES to get average time
           System.out.println("average time: " + averageTime + "nanoseconds");
    }

}
