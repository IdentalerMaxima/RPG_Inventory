import business.Inventory;
import business.Weapon;
import business.os.Item;

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
                        System.out.println("Item name: ");
                        String name = scanner.nextLine();
                        System.out.println("Item weight: ");
                        int weight = Integer.parseInt(scanner.nextLine());
                        System.out.println("Item durability: ");
                        int durability = Integer.parseInt(scanner.nextLine());
                        System.out.println("Item is magic? (true/false)");
                        boolean isMagic = Boolean.parseBoolean(scanner.nextLine());

                        Item item = new Item (name, isMagic, weight, durability);
                        inventory.addItem(item);

                        System.out.println("Item successfully added!");
                        System.out.println("\n" + inventory.getSpaceLeft() +"\n");
                        inventory.displayOptions();
                        System.out.println("\nNext option: ");
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
                        inventory.displayOptions();
                        System.out.println("\nNext option: ");
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

