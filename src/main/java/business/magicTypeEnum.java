package business;

public enum magicTypeEnum {
    FIRE (2), WATER(2), EARTH(2), AIR(2), LIGHT(4), DARK(5), NONE(1);

    private final Integer damageBonus;

    magicTypeEnum(Integer damageBonus) { //elv itt felesleges a lathatosagot megadni
        this.damageBonus = damageBonus;
    }

    public Integer getDamageBonus() {
        return this.damageBonus;
    }
}
