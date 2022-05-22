package business;

import business.os.Item;

public class Weapon extends Item {

    int damage = 10;

    public Weapon(String name, Boolean isMagic, int weight, int durability, Integer damage) {
        super(name, isMagic, weight, durability);
        this.damage = damage;

    }

}
