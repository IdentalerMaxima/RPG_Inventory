import business.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory(); //create inventory

        inventory.displayOptions(); //display options

        System.out.println("What option would you like to choose?");

        try {
            Scanner scanner = new Scanner(System.in);
            int option = Integer.parseInt(scanner.nextLine());

            while (option != 8){
                switch(option){
                    case 1:
                        inventory.addItem();
                        option = Integer.parseInt(scanner.nextLine());
                        break;

                    case 2:
                        inventory.removeItem();
                        option = Integer.parseInt(scanner.nextLine());
                        break;

                    case 3:
                        inventory.printInventoryWeight();
                        inventory.displayOptions();
                        System.out.println("\nNext option: ");
                        option = Integer.parseInt(scanner.nextLine());

                        break;
                    case 4:
                        inventory.displayItems();
                        option = Integer.parseInt(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Invalid option");
                        inventory.displayOptions();
                        System.out.println("\nNext option: ");
                        option = Integer.parseInt(scanner.nextLine());

                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid option!");
        }finally {
            System.out.println("Goodbye!");
        }
    }
}

