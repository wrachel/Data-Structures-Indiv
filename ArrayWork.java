public class ArrayWork {

    public ArrayWork(){

    }

    public static int arraySum(int[] arr){
        int sums = 0;
        for(int i : arr){
            sums += i;
        }
        return sums;
    }

    public static int[] rowSums(int[][] arr2D){

        int size = arr2D.length;
        int[] finalArray = new int[size];

        for(int i = 0; i < arr2D.length; i++){
            finalArray[i] = arraySum(arr2D[i]);
        }

        return finalArray;
    }

    public static boolean isDiverse(int[][] arr2D){
        int[] getArraySums = rowSums(arr2D);
        boolean store = true;

        for(int i = 0; i < getArraySums.length; i++){
            for(int j = i+1; j < getArraySums.length; j++){
                if(getArraySums[i] == getArraySums[j]){
                    store = false;
                }
            }
        }

        return store;
    }

    public static void main(String args[])
    {
        ArrayWork demonstrate = new ArrayWork();

        //demonstrating part a
        int[] arr1 = {1, 3, 4, 7, 3};
        System.out.print("arr1: ");
        for(int i : arr1){
            System.out.print(i + " ");
        }
        System.out.println("\nsum of arr1: " + demonstrate.arraySum(arr1));

        //demonstrating part b
        int[][] mat1 = {{1, 3, 2, 7, 3}, {10, 10, 4, 6, 2}, {5, 3, 5, 9, 6}, {7, 6, 4, 2, 1}};
        System.out.println("\nFor part b, here is the sum of each row: ");
        int[] arr = demonstrate.rowSums(mat1);

        for(int i=0; i < arr.length; i++){
            System.out.print("row " + i + ": sum" + arr[i]+ ", ");
        }

        //demonstrating part c
        int[][] mat2 = {{1, 1, 5, 3, 4}, {12, 7, 6, 1, 9}, {8, 11, 10, 2, 5}, {3, 2, 3, 0, 6}};
        System.out.println("\n\nFor part c, mat1 is diverse: "+ demonstrate.isDiverse(mat1));
        System.out.println("For part c, mat2 is diverse: "+ demonstrate.isDiverse(mat2));

    }

}
