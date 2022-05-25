
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //test();
    }

    public static void test() { //Make the program foolproof
        //int number = option1();
        //String selectedChar = option2();
        //String magical = magicalStatus();

        //System.out.println("You selected: " + number);
        //System.out.println("You selected: " + selectedChar);
        //System.out.println("You selected: " + magical);

        //System.out.println("Goodbye!");

    }

    private static int option1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a number: ");
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            number = option1();
        }
        return number;
    }

    private static String option2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a, b, or c: ");
        String selectedChar = sc.nextLine();
        try {
            if (!selectedChar.equals("a") && !selectedChar.equals("b") && !selectedChar.equals("c")) {
                System.out.println("You have to select a, b or c!");
                tryAgain();
                selectedChar = option2();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid!");
            tryAgain();
            selectedChar = option2();
        }
        return selectedChar;
    }

    private static void tryAgain() {
        System.out.println("Do you wish to try again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if(!answer.equals("y")) {
            if (answer.equals("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("You have to give a y or n!");
                tryAgain();
            }
        }
    }

    private static String magicalStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is the item magical (y/n): ");
        String magicalYesNo = sc.nextLine();

        if (magicalYesNo.equals("y")) {
            magicalYesNo = "true";
        } else if (magicalYesNo.equals("n")) {
            magicalYesNo = "false";
        }else{
            System.out.println("You must enter either y or n");
            tryAgain();
            magicalYesNo = String.valueOf(magicalStatus());
        }
        return magicalYesNo;
    }
}
