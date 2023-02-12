package foods;

import abstraction.Ability;
import abstraction.Food;
import enums.FoodTypeEnum;

public class FightFood extends Food {

    public FightFood() {
        super(FoodTypeEnum.FIGHT_FOOD);
    }

    @Override
    public void effect(Ability ability) {
        double prevValue = ability.getValue();
        ability.setValue(++prevValue);
    }
}
