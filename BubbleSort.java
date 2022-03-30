import java.util.ArrayList;

//compares two entries in the array at a time, and puts lower one down
public class BubbleSort extends Sorts{

    public BubbleSort(int size) {
        super(size);
    }

    void BubbleSort(ArrayList<Integer> arr){
        int n = arr.size();

        for(int i = 0; i < n -1; i++){
            for(int j = 0; j < n - i - 1; j++){

                //if value on left is greater than value on right
                if (arr.get(j) > arr.get(j+1)){
                    //swap value on left with value on right
                    Integer temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }

    }

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
            BubbleSort sort = new BubbleSort(SIZE);
            ArrayList<Integer> arr = sort.getData();
            sort.BubbleSort(arr);

            System.out.print("Sorted array: ");
            sort.printArray(arr);

            times.add(sort.getTimeElapsed());
        }
//        for(Integer a : times){
//
//        }
    }

}
