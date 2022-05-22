package business.os;

public class Item{
    private boolean isMagic;
    private int weight;
    private int durability;

    public Item(){
    }

    public Item(boolean isMagic, int weight, int durability) {
        this.isMagic = isMagic;
        this.weight = weight;
        this.durability = durability;
    }

    public boolean isMagic() {
        return isMagic;
    }

    public int getWeight() {
        return weight;
    }

    public int getDurability() {
        return durability;
    }

}
