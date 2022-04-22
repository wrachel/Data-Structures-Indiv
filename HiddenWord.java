import java.lang.String;
import java.util.Scanner;

public class HiddenWord {
    private String word;
    private int wordlength;

    public HiddenWord(String word){
        this.word=word;
        this.wordlength = word.length();
    }

    public String getHint(String guess){
        String hint = "";

        for(int i = 0;i <word.length(); i++){
            if(guess.charAt(i) == (word.charAt(i))){
                hint += word.charAt(i);
            }
            else if(word.indexOf(guess.substring(i, i+1))!= -1){
                hint += "+";
            }
            else{
                hint += "*";
            }
        }
        System.out.println(hint);
        return hint;
    }

    public static void main(String args[]){
        HiddenWord answer = new HiddenWord("heart");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Try to guess my wordle starter! Your guess should be 5 characters long: ");
        String guess = scanner.nextLine();

        answer.getHint(guess);
    }
}
