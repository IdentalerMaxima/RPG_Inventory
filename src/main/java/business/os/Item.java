package business.os;

public class Item{
    private final String name;
    private boolean isMagic;
    private final int weight;
    private final int durability;
    private String description = "";


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
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

}
