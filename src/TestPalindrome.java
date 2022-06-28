import java.util.Scanner;

public class TestPalindrome {
    public static void main(String[] args) {
        boolean isProgramRunning = true;
        do{
            Stack<String> stack = new Stack<>(); //create stack and scanner. since the instructions ask that we make it of type string, we're using that.
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: "); //get user input string.
            String inputString = sc.nextLine();

            for(int i=0;i<inputString.length();i++){ //Add every single character as a string to the input string to the stack.
                stack.push(String.valueOf(inputString.charAt(i)));
            }

            StringBuilder reversed = new StringBuilder(); //StringBuilder to rebuild the string backwards.

            while(!stack.isEmpty()){ //pop all the characters back out to form the reversed string.
                reversed.append(stack.pop());
            }

            boolean isPalindrome = (reversed.toString().equalsIgnoreCase(inputString)); //check if it's a palindrome, but ignore case.

            System.out.println("\nInput String:\t"+inputString);

            if(isPalindrome){
                System.out.println("Judgement:\t\tPalindrome");
            }else{
                System.out.println("Judgement:\t\tNot Palindrome.");
            }

            System.out.println("Do you want to re-run code with different input string (Y/N)");
            sc = new Scanner(System.in); //make a new scanner to clear previous buffer. (it's the easiest way.)
            if(!sc.next().equalsIgnoreCase("Y")){
                isProgramRunning = false;
            }
        }while(isProgramRunning);
    }
}
