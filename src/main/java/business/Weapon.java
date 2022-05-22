package business;

import business.os.Item;

public class Weapon extends Item {

    int damage = 10;

    public Weapon(Boolean isMagic, int weight, int durability, Integer damage) {
        super(isMagic, weight, durability);
        this.damage = damage;

    }

}
