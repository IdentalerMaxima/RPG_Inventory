package business;

public enum magicTypeEnum {
    FIRE (2), WATER(2), EARTH(2), AIR(2), LIGHT(4), DARK(5);

    private final Integer Multiplier;


    magicTypeEnum(Integer Multiplier) { //elv itt felesleges a lathatosagot megadni
        this.Multiplier = Multiplier;
    }

    public Integer getMultiplier() {
        return this.Multiplier;
    }

}
