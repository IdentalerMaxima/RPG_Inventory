package business.os;

import business.magicTypeEnum;

public class Item{
    private String name;
    private boolean isMagic;
    private int weight;
    private int durability;

    public Item(String name, int weight, int durability) {
        this.name = name;
        this.weight = weight;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getDurability() {
        return durability;
    }

}
