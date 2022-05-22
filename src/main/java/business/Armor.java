package business;

import business.os.Item;

public class Armor extends Item {

    int armorAmount = 10;

    public Armor(Boolean isMagic, int weight, int durability, Integer armorAmount) {
        super(isMagic, weight, durability);
        this.armorAmount = armorAmount;

    }

}
