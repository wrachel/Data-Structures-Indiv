public class IntByReference {

    private int value;

    // Hack: create IntByReference, swapToLowHighOrder and toString methods

    //constructor
    public IntByReference(int value){
        this.value = value;
    }

    //toString method to return value within object
    public String toString(){
        return value + "";
    }

    //getter method
    public int getValue(){
        return value;
    }

    //setter method
    public void setValue(int value){
        this.value = value;
    }

    public void swapToLowHighOrder(IntByReference a){
        //if condition to switch if the 1st value is bigger than the 2nd
        if(this.value > a.getValue()){
            //swapping values of a, b
            int temp = this.value;
            this.value = a.getValue();
            a.setValue(temp);
        }
    }

    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a + " " + b);
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a + " " + b);
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}
