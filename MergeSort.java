import java.util.ArrayList;

/*
How Merge Sort works:
divides input array into two haves, and merges the two sorted halves
how the two halves are sorted:
    essentially, array recursively divides haves until size becomes 1
 */

/*
from GeeksforGeeks explaining how MergeSort works:
MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = l+ (r-l)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
 */

public class MergeSort extends Sorts{

    private ArrayList<Integer> finalarr;

    public MergeSort(int SIZE){
        super(SIZE);
    }


    //this is the function that merges the two separate halves
    void MergeSort(ArrayList<Integer> arr, int init, int middle, int end){
         int size1 = middle - init + 1;
         int size2 = end - middle;

         //creates two arrays that the initial array will split into
         ArrayList<Integer> leftArray = new ArrayList<>(size1);
        ArrayList<Integer> rightArray = new ArrayList<>(size2);

        //essentially adds all the values on the left into the leftArray
        for(int i = 0; i < size1; i++){
            leftArray.add(arr.get(i));
        }
        //adds all the values on the right into the rightArray
        for(int i = 0; i < size2; i++){
            rightArray.add(arr.get(i));
        }

        int leftIndex = 0; //creates counter for leftArray
        int rightIndex = 0; //creates counter for rightArray

        int mergedIndex = 0;

         if(leftIndex < size1 && rightIndex < size2){ //iterates through array
            if(leftArray.get(leftIndex) <= rightArray.get(rightIndex)){ //essentially, if left value is less then right value
                //if the leftIndex is less than rightIndex (essentially, it is in the proper order), then assign the value
                //at the left index to the arr
                arr.set(mergedIndex, leftArray.get(leftIndex));
                leftIndex++;
            }
            else{
                //if value on right is bigger than the one on the left, set the arr to the value on the right
                arr.set(mergedIndex, rightArray.get(rightIndex));
                rightIndex++;
            }
            mergedIndex++;//essentially repeats this while loop until all values are acocunted for
        }
         else if(leftIndex < size1){ //if there are still values left in the left array but not the right array
             arr.set(mergedIndex, leftArray.get(leftIndex));
             leftIndex++;
             mergedIndex++;
         }
         else if(rightIndex < size2){// if there are still values left in right arraylist but not left one
             arr.set(mergedIndex, rightArray.get(rightIndex));
             rightIndex++;
             mergedIndex++;
         }

         finalarr = arr;
    }

    //this is the function that sorts the actual halves
    public void sort(ArrayList<Integer> arr, int start, int end){

        int middle = 0;
        if(end-start > 0){
            //sets what the middle of the array would be
           middle = (end - 1)/2 + 1;

           //essentially what happens next is recursive function on the sorts that occurs until the array is 1

           //sort first half
           sort(arr, start, middle);
           //sort second half
           sort(arr, middle + 1, end);

           //merge two sorted halves
            MergeSort(arr, start, middle, end);
        }
    }

    public String toString(){
        String PrintArray = "";
        for(Integer a : finalarr){
            PrintArray += a + " ";
            System.out.println(finalarr);
        }
        String s = "Sorted Array: " + PrintArray + "Time Elapsed: " + getTimeElapsed() + " nanoseconds" + "\n";
        return s;
    }

    public static void main(String args[]){
        ArrayList<Integer> times = new ArrayList<Integer>();

        int sum=0, time=0, TIMES=12, SIZE=5000;

        for(int i = 0; i < TIMES; i++) {

            //create new instance of InsertionSort
            MergeSort a = new MergeSort(SIZE);
            ArrayList<Integer> NewArr = a.getData(); //assigns data from sort to arr
            a.sort(NewArr, 0, NewArr.size() - 1); //sorts data in array

            a.toString();
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

