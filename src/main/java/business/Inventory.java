package business;

import business.os.Item;

public class Inventory {
    int weightCapacity = 100;
    int currentWeight = 0;

    public void addItem(Item item){
        if(currentWeight + item.getWeight() <= weightCapacity){
            currentWeight += item.getWeight();
        }
    }
    public void removeItem(Item item){
        if(currentWeight - item.getWeight() >= 0){
            currentWeight -= item.getWeight();
        }
    }
    public void printInventoryWeight(){
        System.out.println("Current Weight: " + currentWeight);
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
}
