import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NumberGroup{
    boolean contains(int num);

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        //part b demonstration
        System.out.println("What would you like the min of this range to be?: " );
        int min = scanner.nextInt();

        System.out.println("what would you like the max of this range to be?: ");
        int max = scanner.nextInt();

        NumberGroup rangepartb = new Range(min, max); // create instance of Range

        System.out.println("Input a number to test if it is within the range: ");
        int number = scanner.nextInt();

        boolean result = rangepartb.contains(number);
        System.out.println(number + " is within the range: " + result);

        //part c demonstration
        List <NumberGroup> list = new ArrayList<>();
        NumberGroup range1 = new Range(5, 8);
        NumberGroup range2 = new Range(10, 12);
        NumberGroup range3 = new Range(1, 6);
        list.add(range1);
        list.add(range2);
        list.add(range3);

        NumberGroup test = new MultipleGroups(list);

        System.out.println("Input a random number to see if it is in the 3 ranges specified in the 2015 FRQ: ");
        int userNum = scanner.nextInt();

        System.out.println("The 3 ranges contain "+ userNum + " : " + test.contains(userNum));
    }
}

class Range implements NumberGroup{
    private int low;
    private int high;

    public Range(int num1, int num2){
        low = num1;
        high = num2;
    }
    public boolean contains(int num){
        boolean test = false;
        if(num >= low && num <= high){
            test = true;
        }
        return test;
    }


}

 class MultipleGroups implements NumberGroup{
    private List <NumberGroup> groupList;

    public MultipleGroups(List <NumberGroup> list){
        groupList = list;
    }

    public boolean contains(int num){
        boolean test = false;
        for(NumberGroup i : groupList){
            if(i.contains(num) == true){
                test = true;
            }
        }

        return test;
    }


}