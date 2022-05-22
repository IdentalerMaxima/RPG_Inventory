package business;

import business.os.Item;

import java.util.ArrayList;

public class Inventory {
    int weightCapacity = 100;
    int currentWeight = 0;

    ArrayList<Item> items = new ArrayList<Item>();

    public void getItem(int index) {
        Item item = items.get(index);
        }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("Name: " + item.getName() + "\n" + "Weight: " + item.getWeight() + "\t"
                            + "Durability: " + item.getDurability() + "\t" + "Magical: " + item.isMagic() + "\n");
        }
    }


    public void addItem(Item item){
        if(currentWeight + item.getWeight() <= weightCapacity){
            currentWeight += item.getWeight();
        }
        items.add(item);
    }
    public void removeItem(Item item){
        if(currentWeight - item.getWeight() >= 0){
            currentWeight -= item.getWeight();
        }
    }
    public void printInventoryWeight(){
        System.out.println("Current Weight: " + currentWeight + "\n");
    }
    public void addWeapon(Weapon weapon){
        addItem(weapon);
    }
    public void removeWeapon(Weapon weapon){
        removeItem(weapon);
    }
    public void addArmor(Armor armor){
        addItem(armor);
    }
    public void removeArmor(Armor armor){
        removeItem(armor);
    }
    public void displayOptions(){
        System.out.println("1. Add item");
//        System.out.println("2. Remove item");
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
}

