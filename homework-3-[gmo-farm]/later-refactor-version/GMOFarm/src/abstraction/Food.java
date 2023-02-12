package abstraction;

import enums.FoodTypeEnum;

public abstract class Food {

    private final FoodTypeEnum typeOfFood;

    public Food(FoodTypeEnum typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public abstract void effect(Ability ability);

    public boolean isTransportFood(){
        return typeOfFood.equals(FoodTypeEnum.TRANSPORT_FOOD);
    }

    public boolean isFightFood(){
        return typeOfFood.equals(FoodTypeEnum.FIGHT_FOOD);
    }

    public boolean isNutritionalFood(){
        return typeOfFood.equals(FoodTypeEnum.NUTRITIONAL_FOOD);
    }
}
