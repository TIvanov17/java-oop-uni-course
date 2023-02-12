package foods;

import abstraction.Ability;
import abstraction.Food;
import enums.FoodTypeEnum;

public class NutritionalFood extends Food {

    public NutritionalFood() {
        super(FoodTypeEnum.NUTRITIONAL_FOOD);
    }

    @Override
    public void effect(Ability ability) {
        double prevValue = ability.getValue();
        ability.setValue(prevValue + (prevValue * 0.1));
    }
}
