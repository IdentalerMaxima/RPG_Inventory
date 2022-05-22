package business.os;

public class Item{
    private String name;
    private boolean isMagic;
    private int weight;
    private int durability;

    public Item(){
    }

    public Item(String name, Boolean isMagic, int weight, int durability) {
        this.name = name;
        this.isMagic = isMagic;
        this.weight = weight;
        this.durability = durability;
    }
    public String getName() {
        return name;
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
