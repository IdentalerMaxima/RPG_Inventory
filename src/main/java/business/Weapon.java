package business;

import business.os.Item;

public class Weapon extends Item {
    Weapon(){
        int damage = 10;
        super.weight = 5;
        super.durability = 50;
        super.isMagic = false;
    }

}
