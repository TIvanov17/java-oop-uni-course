package abstraction;

import utility.Util;

public class Ability {

    private static final int ATTRIBUTE_VALUE_LOWER_BOUND = 1;
    private static final int ATTRIBUTE_VALUE_UPPER_BOUND = 10;
    private static final int SLEEPING_ABILITY_VALUE = 0;

    private final String name;
    private double value;

    protected Ability(String name) {

        this.name = name;
        this.value = setRandomValueToAnimalAttribute();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    protected void setAbilityValueToZero(){
        this.value = SLEEPING_ABILITY_VALUE;
    }

    protected String getName() {
        return name;
    }

    private int setRandomValueToAnimalAttribute(){
        return Util.generateRandomAbilityValue(ATTRIBUTE_VALUE_LOWER_BOUND, ATTRIBUTE_VALUE_UPPER_BOUND);
    }
}
