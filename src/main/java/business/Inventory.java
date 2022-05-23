package business;

import business.os.Item;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inventory {
    int weightCapacity = 100;
    int currentWeight = 0;

    ArrayList<Item> items = new ArrayList<>();

    //menu1 methods
    public void menu1(){

        boolean exit = false;
        while (!exit){
            try {
                displayOptions();
                Scanner scanner = new Scanner(System.in);
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> {
                        addItem();
                        menu1();
                    }
                    case 2 -> {
                        quickRemove();
                        menu1();
                    }
                    case 3 -> {
                        printInventoryWeight();
                        menu1();
                    }
                    case 4 -> {
                        displayItems();
                        menu1();
                    }
                    case 5 -> {
                        selectItem();
                        menu1();
                    }
                    case 8 -> exit = true;
                    default -> {
                        System.out.println("Invalid option");
                        displayOptions();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please enter a valid option");
            }
        }
            System.out.println("Thank you for using the inventory system!");
    }
    public void displayOptions(){
        System.out.println("""
                What would you like to do?
                1. Add an item
                2. Remove an item
                3. Display the weight of the inventory
                4. Display the items in the inventory
                5. Select item
                8. Exit""");
    }
    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Item name: ");
        String name = scanner.nextLine();

        System.out.println("Armor, weapon or else? (a/w/e): ");
        String armorWeaponElse = scanner.nextLine();

        System.out.println("Item durability: ");
        int durability = Integer.parseInt(scanner.nextLine());

        System.out.println("Item weight: ");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Is the item magical (y/n): ");
        String magical = scanner.nextLine();
        boolean isMagic;
        if(magical.equals("y")){
            isMagic = true;
        }else if(magical.equals("n")){
            isMagic = false;
        }else {
            System.out.println("Invalid input");
            isMagic = false;
        }

        if (armorWeaponElse.equals("a") && isMagic) { //magic armor

            System.out.println("Specify magic type (fire/water/earth/air/light/dark): ");
            magicTypeEnum magicType = magicTypeEnum.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT));

            System.out.println("Item armor amount: ");
            int armorAmount = Integer.parseInt(scanner.nextLine());

            Armor item  = new Armor(name, magicType, weight, durability, armorAmount);
            addItemToInv(item);

        } else if (armorWeaponElse.equals("w") && isMagic) { //magic weapon
            System.out.println("Specify magic type (fire/water/earth/air/light/dark) ");
            magicTypeEnum magicType = magicTypeEnum.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT));

            System.out.println("Item damage: ");
            int damage = Integer.parseInt(scanner.nextLine());

            Weapon item = new Weapon(name, magicType, weight, durability, damage);
            addItemToInv(item);


        } else if (armorWeaponElse.equals("a")) { //non-magic armor
            System.out.println("Item armor amount: ");
            int armorAmount = Integer.parseInt(scanner.nextLine());

            Armor item = new Armor(name, weight, durability, armorAmount);
            addItemToInv(item);

        } else if (armorWeaponElse.equals("w")) { //non-magic weapon
            System.out.println("Item damage: ");
            int damage = Integer.parseInt(scanner.nextLine());

            Weapon weapon = new Weapon(name, weight, durability, damage);
            addItemToInv(weapon);

        }else {
            Item item = new Item(name, weight, durability); //Item is not magic
            addItemToInv(item);
        }
    }                 //option 1
    public void quickRemove(){
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
    }              //option 2
    public void printInventoryWeight(){
        System.out.println("Current Weight: " + 
                currentWeight + "\n");
    }     //option 3
    public void displayItems() {
        int index = 1;
        System.out.println("Inventory: ");
        System.out.println("--------------------------------------------------------------------------------");
        if (items.size() == 0) {
            System.out.println("No items in inventory");
        } else {
            for (Item item : items) {
                System.out.println(index + ". " + item.getName());
                if (item instanceof Armor) {
                    if (((Armor) item).magicType != null) {
                        System.out.println("Armor: " + ((Armor) item).getArmor() + "\tMagic type: " + ((Armor) item).getMagicType());

                    }else if(((Armor) item).magicType == null){
                        System.out.println("Armor: " + ((Armor) item).getArmor());
                    }
                } else if (item instanceof Weapon) {
                    if (((Weapon) item).magicType != null) {
                        System.out.println("Damage: " + ((Weapon) item).getDamage() + "\tMagic type: " + ((Weapon) item).getMagicType());
                    }else if(((Weapon) item).magicType == null){
                        System.out.println("Damage: " + ((Weapon) item).getDamage());
                    }

                }
                System.out.println("Weight: " + item.getWeight() + "\tDurability: " + item.getDurability());

                if (index != items.size()) {
                    System.out.println("------------------------------");
                }
                index++;
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }            //option 4
    public void selectItem(){
        menu2();
    }       //option 5

    //menu2 methods
    public void menu2(){
        int selectedItem = getIndex();
        
        boolean exit = false;
        while (!exit){
            try {
                Scanner scanner = new Scanner(System.in);
                displaySelectionOptions();
                int selectedOption = Integer.parseInt(scanner.nextLine());
                switch (selectedOption) {
                    case 1 -> {
                        getItemDetails(selectedItem);
                        menu2();
                    }
                    case 2 -> {
                        removeItem(selectedItem);
                        menu2();
                    }
                    case 3 -> {
                        addItemDescription(selectedItem);
                        menu2();
                    }
                    case 4 -> {
                        upgradeItem(selectedItem);
                        menu2();
                    }
                    case 5 -> exit = true;
                }
                
            } catch (Exception e) {
                System.out.println("Invalid input" + e);
                menu2();
            }
        }
    }

    private void upgradeItem(int selectedItem) {
    }

    private void addItemDescription(int selectedItem) {
    }

    private void removeItem(int selectedItem) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you sure you want to remove " + items.get(selectedItem).getName() + "? (y/n)");
        if (scanner.nextLine().equals("y")) {
            currentWeight -= items.get(selectedItem).getWeight();
            items.remove(selectedItem);
            System.out.println("Item successfully removed!");
            System.out.println("\n" + getSpaceLeft() +"\n");
            menu2();

        }
        else if (scanner.nextLine().equals("n")){
            System.out.println("Item was not removed!");
        } else {
            System.out.println("Invalid input!");
            System.out.println("Do you wish to continue?");
            if (scanner.nextLine().equals("y")) {
                removeItem(selectedItem);
            }else{
                menu2();
            }
        }

    }

    private void getItemDetails(int selectedItem) {
    }

    public void displaySelectionOptions(){
        System.out.println("""

                Select an option:\s
                1. Details of item
                2. Remove item
                3. Add description
                4. Upgrade item
                5. Back to main menu""");
        
    }
    public int getIndex(){
        System.out.println("Index of item to select: ");
        Scanner scanner = new Scanner(System.in);
        int selectedItem = Integer.parseInt(scanner.nextLine());
        
        if (selectedItem > items.size() || selectedItem < 1) {
            System.out.println("Invalid index!");
            System.out.println("Do you want to try again? (y/n)");
            if (scanner.nextLine().equals("y")) {
                getIndex();
            } else if(scanner.nextLine().equals("n")) {
                selectedItem = -1;
            }

        }
        return selectedItem - 1;
    } //returns index of item selected, yes the actual INDEX.

    //extra methods
    public String getSpaceLeft() {
        return "Space left: " + (weightCapacity - currentWeight);
    }
    public void addItemToInv(Item item) {   //check if item can be added
        if (currentWeight + item.getWeight() <= weightCapacity) {
            items.add(item);
            System.out.println("Item successfully added!");
            currentWeight += item.getWeight();
        }
        else {
            System.out.println("Not enough space!");
        }

        System.out.println("\n" + getSpaceLeft() +"\n");
    }












}

