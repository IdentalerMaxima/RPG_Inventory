package business;

import business.os.Item;

public class Weapon extends Item {

    int damage;
    magicTypeEnum magicType;

    public Weapon(String name, int weight, int durability, int damage) { //non-magic
        super(name, weight, durability);
        this.damage = damage;

    }

    public Weapon(String name, String magicType, int weight, int durability, int damage) { //magic
        super(name, weight, durability);
        this.damage = damage;
        this.magicType = magicTypeEnum.valueOf(magicType);
    }

}
