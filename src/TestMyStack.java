import java.util.Scanner;

public class TestMyStack {
    public static void main(String[] args) {

        boolean isTestProgramRunning = true;Stack<Integer> testStack = new Stack<>(); //For this test program as instructed,we are going to use integer as the type of stack.

        do{
            printMenu();
            switch (getValidateUserMenuInput()){
                case 1 ->{//push
                    System.out.println("Testing method push()");
                    Integer data = getUserData();
                    System.out.println("Pushing Data onto the stack.");
                    System.out.println("Stack content before adding "+data+" is: ");
                    testStack.print();

                    testStack.push(data);

                    System.out.println("\nStack content after adding "+data+" is: ");
                    testStack.print();
                }
                case 2->{//pop
                    System.out.println("Testing method pop()");
                    System.out.println("Stack content before popping is: ");
                    testStack.print();

                    Integer poppedElem = testStack.pop(); //All remove methods throw EmptyStackException if called on an empty stack.

                    System.out.println("\nStack content after popping is: ");
                    testStack.print();

                    System.out.println("Element popped was: "+poppedElem);
                }
                case 3->{//top, no need to print the stack content since we're not adding/removing, just looking at top.
                    System.out.println("Testing method top()");
                    Integer topElem = testStack.top(); //All access methods throw EmptyStackException if called on an empty stack.
                    System.out.println("Top element is: "+topElem);
                }
                case 4->{//size, no need to print out stack content since we're not adding/removing just getting size attribute.
                    System.out.println("Testing method size()");
                    int size = testStack.size();
                    System.out.println("Size is: "+size);
                }
                case 5->{ //isEmpty, we don't have to print out stack content since we're not adding/removing.
                    System.out.println("Testing method isEmpty()");
                    System.out.println(testStack.isEmpty());
                }
                case 6->{//print, we don't have to print out stack content since we're not adding/removing.
                    System.out.println("Testing method print()");
                    testStack.print();
                }
                case 7->{
                    System.out.println("Terminating program, thank you.");
                    isTestProgramRunning = false;
                }
            }
        }while (isTestProgramRunning);

    }

    /**
     * This method prints the menu for the user.
     */
    public static void printMenu(){
        System.out.println();
        System.out.println("---------MAIN MENU--------");
        System.out.println("1 – Push element");
        System.out.println("2 – Pop element ");
        System.out.println("3 – Top element");
        System.out.println("4 – Size of stack");
        System.out.println("5 – Is Empty stack?");
        System.out.println("6 - Print stack content");
        System.out.println("7 - Exit program\n");
    }

    /**
     * This method gets and validates user input. This method should be called every time the menu is called to get an input
     * from the user regrading their choice on the menu.
     */
    public static int getValidateUserMenuInput(){
        boolean testPassed = false;
        int userInputInteger = 0;
        while(!testPassed){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter option number: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine());
                if(userInputInteger>0 && userInputInteger <= 7){ //if the number is actually a valid menu option, return that number.
                    testPassed = true;
                }else{
                    System.out.println("Please enter a number between 1-7.");
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter an Integer.");
            }
        }
        return userInputInteger;
    }

    /**
     * This method prompts the user to enter a value for the Data node which will then be returned to the caller.
     */
    public static int getUserData(){
        boolean testPassed = false;
        int userInputInteger = 0;
        while(!testPassed){
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter a value for the Data node: ");
            try{
                userInputInteger = Integer.parseInt(sc.nextLine()); //Try to parse the user Input into an Integer, and break out of loop if successful.
                testPassed = true;
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer.");
            }
        }
        return userInputInteger;
    }
}
