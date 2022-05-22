package business;

import business.os.Item;

public class Armor extends Item {

    int baseArmor;
    magicTypeEnum magicType;

    public Armor(String name, int weight, int durability, int baseArmor) { //non-magic
        super(name, weight, durability);
        this.baseArmor = baseArmor;
    }

    public Armor(String name, magicTypeEnum magicType, int weight, int durability, int baseArmor) {
        super(name, weight, durability);
        this.baseArmor = baseArmor;
        this.magicType = magicType;

    }

    public int getArmor() {
        if (magicType == null) {
            return baseArmor;
        } else {
            return baseArmor * magicType.getMultiplier();
        }
    }

    public magicTypeEnum getMagicType() {
        return magicType;
    }

}
