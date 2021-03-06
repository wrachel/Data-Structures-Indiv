import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;


public class Sorts {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;

    public Sorts(int size) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }
        // use Inheritance and Polymorphism to replace data.sort with your own algorithm
        sort(data);
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }
    //added new constructor with a parameter of an Array List of integers
    public Sorts(ArrayList<Integer> arr) {
        Instant start = Instant.now();
        //sorts the inputted Array List
        sort(arr);
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }
    public void sort(ArrayList<Integer> s){

    }
    public void sort(ArrayList<Integer> arr, int start, int end){

    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }


    public static void main(String[] args) {
        int sum=0, time=0, TIMES=12, SIZE=5000, swaps=0, comparisons=0;
        //BUBBLE SORT
        for(int i=0; i< TIMES; i++) {
            BubbleSort s = new BubbleSort(SIZE);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                // System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            //System.out.println("Average random: " + sum / ((i+1)*SIZE));
            //System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
            swaps = s.getSwaps();
            comparisons = s.getComparisons();
        }
        System.out.println("BubbleSort Average random: " + sum / (TIMES*SIZE));
        System.out.println("BubbleSort Total Nanoseconds: " + time );
        System.out.println("BubbleSort Total Seconds: " + time /1000000000.0);
        System.out.println("BubbleSort Comparisons: "+ comparisons);
        System.out.println("BubbleSort swaps: "+ swaps);

        //SELECTION SORT
        sum=0;
        time=0;
        for(int i=0; i< TIMES; i++) {
            SelectionSort s = new SelectionSort(SIZE);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                //System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            //System.out.println("Average random: " + sum / ((i+1)*SIZE));
            //System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
            swaps = s.getSwaps();
            comparisons = s.getComparisons();
        }
        System.out.println("\nSelectionSort Average random: " + sum / (TIMES*SIZE));
        System.out.println("SelectionSort Total Nanoseconds: " + time );
        System.out.println("SelectionSort Total Seconds: " + time /1000000000.0);
        System.out.println("SelectionSort Comparisons: "+ comparisons);
        System.out.println("SelectionSort swaps: "+ swaps);

        //INSERTION SORT
        sum=0;
        time=0;
        for(int i=0; i< TIMES; i++) {
            InsertionSort s = new InsertionSort(SIZE);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                //System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            //System.out.println("Average random: " + sum / ((i+1)*SIZE));
            //System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
            swaps = s.getSwaps();
            comparisons = s.getComparisons();
        }
        System.out.println("\nInsertionSort Average random: " + sum / (TIMES*SIZE));
        System.out.println("InsertionSort Total Nanoseconds: " + time );
        System.out.println("InsertionSort Total Seconds: " + time /1000000000.0);
        System.out.println("InsertionSort Comparisons: "+ comparisons);
        System.out.println("InsertionSort swaps: "+ swaps);

        //MERGE SORT
        sum=0;
        time=0;
        for(int i=0; i< TIMES; i++) {
            MergeSort s = new MergeSort(SIZE);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                //System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            //System.out.println("Average random: " + sum / ((i+1)*SIZE));
            //System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
            swaps = s.getSwaps();
            comparisons = s.getComparisons();
        }
        System.out.println("\nMergeSort Average random: " + sum / (TIMES*SIZE));
        System.out.println("MergeSort Total Nanoseconds: " + time );
        System.out.println("MergeSort Total Seconds: " + time /1000000000.0);
        System.out.println("MergeSort Comparisons: "+ comparisons);
        System.out.println("MergeSort swaps: None, merge sort does not have swaps");

    }

}

