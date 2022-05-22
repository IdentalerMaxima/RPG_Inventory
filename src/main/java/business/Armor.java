package business;

import business.os.Item;

public class Armor extends Item {

    int armorAmount;
    magicTypeEnum magicType;

    public Armor(String name, int weight, int durability, int armorAmount) { //non-magic
        super(name, weight, durability);
        this.armorAmount = armorAmount;
    }

    public Armor(String name, String magicType, int weight, int durability, int armorAmount) {
        super(name, weight, durability);
        this.armorAmount = armorAmount;
        this.magicType = magicTypeEnum.valueOf(magicType);
    }

}
