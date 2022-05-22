package business;

import business.os.Item;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inventory {
    int weightCapacity = 100;
    int currentWeight = 0;

    ArrayList<Item> items = new ArrayList<>();

    public void displayOptions(){
        System.out.println("1. Add item");
        System.out.println("2. Remove item");
        System.out.println("3. Print inventory weight");
        System.out.println("4. Display inventory");
        System.out.println("8. Exit");
    }

    public String getSpaceLeft() {
        return "Space left: " + (weightCapacity - currentWeight);
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
    }

    public void addItemToInv(Item item) {   //check if item can be added
        if (currentWeight + item.getWeight() <= weightCapacity) {
            items.add(item);
            currentWeight += item.getWeight();
        }
        else {
            System.out.println("Not enough space!");
        }

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

    public void printInventoryWeight(){
        System.out.println("Current Weight: " + currentWeight + "\n");
        displayOptions();
        System.out.println("\nNext option: ");
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
        displayOptions();
        System.out.println("\nNext option: ");
    }





}

