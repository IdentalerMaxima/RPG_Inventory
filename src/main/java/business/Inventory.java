package business;

import business.os.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    int weightCapacity = 100;
    int currentWeight = 0;

    ArrayList<Item> items = new ArrayList<Item>();

    public void getItem(int index) {
        Item item = items.get(index);
        }

    public void displayItems() {
        int index = 1;
        System.out.println("Inventory: ");
        System.out.println("--------------------------------------------------------------------------------");
        if (items.size() == 0) {
            System.out.println("No items in inventory");
        } else {
            for (Item item : items) {
                System.out.println(index + ". " + item.getName());
                index++;
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
        displayOptions();
        System.out.println("\nNext option: ");
    }

    public void addItem(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Item name: ");
            String name = scanner.nextLine();

            System.out.println("Item is magic? (true/false)");
            boolean isMagic = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Item durability: ");
            int durability = Integer.parseInt(scanner.nextLine());

            System.out.println("Item weight: ");
            int weight = Integer.parseInt(scanner.nextLine());

            if(currentWeight + weight <= weightCapacity){

            currentWeight += weight;

            items.add(new Item(name, isMagic, weight, durability));
            }
            else{
                System.out.println("You can't carry that much weight!");
            }

            System.out.println("Item successfully added!");
            System.out.println("\n" + getSpaceLeft() +"\n");
            displayOptions();
            System.out.println("\nNext option: ");
        }

    public void removeItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Index of item to remove: ");
        int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if(removeIndex > items.size()-1){
            System.out.println("Invalid index!");
        }
        else{
            currentWeight -= items.get(removeIndex).getWeight();
            System.out.println("Are you sure you want to remove " + items.get(removeIndex).getName() + "? (y/n)");
            if (scanner.nextLine().equals("y")) {
                items.remove(removeIndex);
                System.out.println("Item successfully removed!");
                System.out.println("\n" + getSpaceLeft() +"\n");
            }
            else{
                System.out.println("Item not removed!");
            }

            displayOptions();
            System.out.println("\nNext option: ");
        }
    }

    public void displayOptions(){
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Print inventory weight");
        System.out.println("4. Display inventory");
//        System.out.println("5. Remove weapon");
//        System.out.println("6. Add armor");
//        System.out.println("7. Remove armor");
        System.out.println("8. Exit");
    }

    public String getSpaceLeft() {
        return "Space left: " + (weightCapacity - currentWeight);
    }
    public void printInventoryWeight(){
        System.out.println("Current Weight: " + currentWeight + "\n");
    }
}

