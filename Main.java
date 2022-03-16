import java.util.Scanner; //java library for user input

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RunnableFuture;


public class Main {  
    String title;
    Runnable action;

    public Main(String title, Runnable action) {
        //constructor
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return this.title; //getter for title
    }

    public Runnable getAction() {
        return this.action; //getter for the action that should be run
    }

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);

        //Hash map to put the different options for the menu
        Map<Integer, Main> menu = new HashMap<>();

      //menu options
        menu.put(1, new Main("IntByReference", () -> IntByReference.main(null) ) );
        menu.put(2, new Main("Matrix", () -> Matrix.main(null) ) );
      
        //prints the menu
        System.out.println("Menu:");

        for (Map.Entry<Integer, Main> pair : menu.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue().getTitle());
        }

        //scanner gets user input for menu selection
        int input = sc.nextInt();

        try {
            //according to user input, return the method at the Map's index
            Main m = menu.get(input);
            //run action
            m.getAction().run();
            System.out.println("");

        } catch (Exception e){
            //exception for if user puts something not applicable
            System.out.println("Something went wrong. Please try again. \n");
        }

        //recursive statement to get menu to run again
        Main.main(args);
    }

}