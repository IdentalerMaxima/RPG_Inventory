package business;

import business.os.Item;

public class Armor extends Item {

    int armorAmount = 10;

    public Armor(String name, Boolean isMagic, int weight, int durability, Integer armorAmount) {
        super(name, isMagic, weight, durability);
        this.armorAmount = armorAmount;

    }

}
