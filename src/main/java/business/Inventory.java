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
    public void menu1() {
        boolean exit = false;
        while (!exit) {
            try {
                displayOptions();
                Scanner scanner = new Scanner(System.in);
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1 -> addItem();
                    case 2 -> quickRemove();
                    case 3 -> printInventoryWeight();
                    case 4 -> displayItems();
                    case 5 -> selectItem();
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
    public void displayOptions() {
        System.out.println("""
                ------------------------------------------------
                MAIN MENU
                ------------------------------------------------
                1. Add an item
                2. Remove an item
                3. Display the weight of the inventory
                4. Display the items in the inventory
                5. Select item
                8. Exit
                ------------------------------------------------""");
    }
    public void addItem() {
        String name = addItemName();
        if (name.equals("Ruling Ring") || name.equals("One Ring") || name.equals("Great Ring of Power") || name.equals("Isildur's Bane")){
            System.out.println("You can not wield it! The One Ring answers to Sauron alone, it has no other master!");
            System.exit(0);
        }
        String armorWeaponElse = armorWeaponElse();    //Returns type of item (armor, weapon, else)
        int durability = addItemDurability();          //Returns durability of item
        int weight = addItemWeight();                  //Returns weight of item
        String magical = magicalStatus();              //Returns if item is magical or not


        if (armorWeaponElse.equals("a") && magical.equals("true")) { //magic armor
            int armorAmount = addItemArmor();              //Returns armor of item
            magicTypeEnum magicType = addItemMagicType(); //Returns magic type of item
            Armor item = new Armor(name, magicType, weight, durability, armorAmount);
            addItemToInv(item);

        } else if (armorWeaponElse.equals("w") && magical.equals("true")) { //magic weapon
            int damage = addItemDamage();                  //Returns damage of item
            magicTypeEnum magicType = addItemMagicType(); //Returns magic type of item
            Weapon item = new Weapon(name, magicType, weight, durability, damage);
            addItemToInv(item);
        } else if (armorWeaponElse.equals("a")) { //non-magic armor
            int armorAmount = addItemArmor();              //Returns armor of item
            Armor item = new Armor(name, weight, durability, armorAmount);
            addItemToInv(item);

        } else if (armorWeaponElse.equals("w")) { //non-magic weapon
            int damage = addItemDamage();                  //Returns damage of item
            Weapon item = new Weapon(name, weight, durability, damage);
            addItemToInv(item);

        } else {
            Item item = new Item(name, weight, durability); //Item is not magic
            addItemToInv(item);
        }
        menu1();
    }                 //option 1
    public void quickRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Index of item to remove: ");
        int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (removeIndex > items.size() - 1) {
            System.out.println("Invalid index!");
        } else {
            currentWeight -= items.get(removeIndex).getWeight();
            System.out.println("Are you sure you want to remove " + items.get(removeIndex).getName() + "? (y/n)");
            if (scanner.nextLine().equals("y")) {
                items.remove(removeIndex);
                System.out.println("Item successfully removed!");
                System.out.println("\n" + getSpaceLeft() + "\n");
            } else {
                System.out.println("Item not removed!");
            }
        }
        menu1();
    }              //option 2
    public void printInventoryWeight() {
        System.out.println("Current Weight: " + currentWeight + "\n");
        menu1();
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

                    } else if (((Armor) item).magicType == null) {
                        System.out.println("Armor: " + ((Armor) item).getArmor());
                    }
                } else if (item instanceof Weapon) {
                    if (((Weapon) item).magicType != null) {
                        System.out.println("Damage: " + ((Weapon) item).getDamage() + "\tMagic type: " + ((Weapon) item).getMagicType());
                    } else if (((Weapon) item).magicType == null) {
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
        menu1();
    }            //option 4
    public void selectItem() {
        menu2();
    }       //option 5

    //menu2 methods
    public void menu2() {
        int selectedItem = getIndex() - 1;
        System.out.println("You have selected: " + items.get(selectedItem).getName());

        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            displaySelectionOptions();
            int selectedOption = Integer.parseInt(scanner.nextLine());



            try {
                switch (selectedOption) {
                    case 1 -> getItemDetails(selectedItem);
                    case 2 -> removeItem(selectedItem);
                    case 3 -> addItemDescription(selectedItem);
                    case 4 -> upgradeItem(selectedItem);
                    case 5 -> exit = true;
                }

            } catch (Exception e) {
                System.out.println("Invalid input" + e);
                menu2();
            }
        }
    }
    public void upgradeItem(int selectedItem) {
    }
    public void addItemDescription(int selectedItem) {
        System.out.println("Add description of: " + items.get(selectedItem).getName());
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();
        items.get(selectedItem).setDescription(description);

    }
    public void removeItem(int selectedItem) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you sure you want to remove " + items.get(selectedItem).getName() + "? (y/n)");
        if (scanner.nextLine().equals("y")) {
            currentWeight -= items.get(selectedItem).getWeight();
            items.remove(selectedItem);
            System.out.println("Item successfully removed!");
            System.out.println("\n" + getSpaceLeft() + "\n");
            menu2();

        } else if (scanner.nextLine().equals("n")) {
            System.out.println("Item was not removed!");
        } else {
            System.out.println("Invalid input!");
            System.out.println("Do you wish to continue?");
            if (scanner.nextLine().equals("y")) {
                removeItem(selectedItem);
            } else {
                menu2();
            }
        }

    }
    public void getItemDetails(int selectedItem) {
        Item item = items.get(selectedItem);
        String itemDescription;

        if (item instanceof Armor) {
            if (((Armor) item).magicType != null) {
                System.out.println("Armor: " + ((Armor) item).getArmor() + "\tMagic type: " + ((Armor) item).getMagicType());

            } else if (((Armor) item).magicType == null) {
                System.out.println("Armor: " + ((Armor) item).getArmor());
            }
        } else if (item instanceof Weapon) {
            if (((Weapon) item).magicType != null) {
                System.out.println("Damage: " + ((Weapon) item).getDamage() + "\tMagic type: " + ((Weapon) item).getMagicType());
            } else if (((Weapon) item).magicType == null) {
                System.out.println("Damage: " + ((Weapon) item).getDamage());
            }

        }
        System.out.println("Weight: " + item.getWeight() + "\tDurability: " + item.getDurability());
        itemDescription = item.getDescription();
        if (itemDescription.equals("")){
            System.out.println("Description yet to be added...");
        }else{
            System.out.println(itemDescription);
        }



    }
    public void displaySelectionOptions() {
        System.out.println("""
                ------------------------------------------------
                SELECTION MENU
                ------------------------------------------------
                1. Details of item
                2. Remove item
                3. Add description
                4. Upgrade item
                5. Back to main menu
                ------------------------------------------------
                """);

    }
    public int getIndex() {
        System.out.println("No. of item to select: ");
        Scanner scanner = new Scanner(System.in);
        int selectedItem = Integer.parseInt(scanner.nextLine());

        if (selectedItem > items.size() + 1 || selectedItem < 1) {
            System.out.println("Invalid index!");
            tryAgain2();
        }
        return selectedItem;
    }

    //addItem methods
    public String addItemName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of item: ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Invalid input");
            name = addItemName();
        }
        return name;
    }
    public int addItemWeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Item weight: ");
        int weight;
        try {
            weight = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            weight = addItemWeight();
        }
        return weight;
    }
    public int addItemDurability() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Item durability: ");
        int durability;
        try {
            durability = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            durability = addItemDurability();
        }
        return durability;
    }
    public String armorWeaponElse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Armor, weapon or else? (a/w/e): ");
        String selectedChar = sc.nextLine();
        try {
            if (!selectedChar.equals("a") && !selectedChar.equals("w") && !selectedChar.equals("e")) {
                System.out.println("You have to select a, w or e!");
                tryAgain();
                selectedChar = String.valueOf(armorWeaponElse());
            }
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            selectedChar = armorWeaponElse();
        }
        return selectedChar;
    }
    public String magicalStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is the item magical (y/n): ");
        String magicalYesNo = sc.nextLine();

        if (magicalYesNo.equals("y")) {
            magicalYesNo = "true";
        } else if (magicalYesNo.equals("n")) {
            magicalYesNo = "false";
        } else {
            System.out.println("You must enter either y or n");
            tryAgain();
            magicalYesNo = String.valueOf(magicalStatus());
        }
        return magicalYesNo;
    }
    public magicTypeEnum addItemMagicType() {

        magicTypeEnum magicType;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Specify magic type (fire/water/earth/air/light/dark): ");
            magicType = magicTypeEnum.valueOf(sc.nextLine().toUpperCase(Locale.ROOT));

            if (!magicType.equals(magicTypeEnum.FIRE) && !magicType.equals(magicTypeEnum.WATER) && !magicType.equals(magicTypeEnum.EARTH)
                    && !magicType.equals(magicTypeEnum.AIR) && !magicType.equals(magicTypeEnum.LIGHT) && !magicType.equals(magicTypeEnum.DARK)) {
                System.out.println("You must enter a valid magic type");
                tryAgain();
                magicType = addItemMagicType();
            } else {
                magicType = magicTypeEnum.valueOf(magicType.toString().toUpperCase(Locale.ROOT));
            }

        } catch (Exception e) {
            System.out.println("You must enter a valid magic type");
            tryAgain();
            magicType = addItemMagicType();
        }
        return magicType;
    }
    public int addItemArmor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Item armor: ");
        int damage;
        try {
            damage = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            damage = addItemWeight();
        }
        return damage;

    }
    public int addItemDamage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Item damage: ");
        int damage;
        try {
            damage = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to give a number!");
            tryAgain();
            damage = addItemDamage();
        }
        return damage;
    }


    //extra methods
    public String getSpaceLeft() {
        return "Space left: " + (weightCapacity - currentWeight);
    }
    public void addItemToInv(Item item) {   //check if item can be added
        if (currentWeight + item.getWeight() <= weightCapacity) {
            items.add(item);
            System.out.println("Item successfully added!");
            currentWeight += item.getWeight();
        } else {
            System.out.println("Not enough space!");
        }

        System.out.println("\n" + getSpaceLeft() + "\n");
    }
    public void tryAgain() {
        System.out.println("Do you wish to try again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (!answer.equals("y")) {
            if (answer.equals("n")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("You have to give a y or n!");
                tryAgain();
            }
        }
    }
    public void tryAgain2(){
        System.out.println("Do you wish to try again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("y")) {
            getIndex();
        }else if (answer.equals("n")) {
            menu1();
        } else {
            System.out.println("You have to give a y or n!");
            tryAgain();
        }
    }
}