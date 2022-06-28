import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        boolean isProgramRunning = true;
        do{
            Stack<String> stack = new Stack<>();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: "); //get user input
            String inputString = sc.nextLine();

            String[] words = inputString.split("\\s"); //split all the words up based on spaces.

            for(int i=0;i< words.length;i++){ //Add all the individual words to the stack.
                stack.push(words[i]);
            }

            StringBuilder reversed = new StringBuilder(); //StringBuilder to put the reversed string back together.

            while(!stack.isEmpty()){ //pop all the values in the stack.
                reversed.append(stack.pop());
                reversed.append(" ");
            }
            reversed.deleteCharAt(reversed.length()-1); //remove the last extra space.

            System.out.println("\nInput String:\t\t"+inputString); //print the outputs and inputs.
            System.out.println("Reversed String:\t"+reversed);

            System.out.println("Do you want to re-run code with different input string (Y/N)");
            sc = new Scanner(System.in); //make a new scanner to clear previous buffer. (it's the easiest way.)
            if(!sc.next().equalsIgnoreCase("Y")){
                isProgramRunning = false;
            }
        }while(isProgramRunning);
    }
}
