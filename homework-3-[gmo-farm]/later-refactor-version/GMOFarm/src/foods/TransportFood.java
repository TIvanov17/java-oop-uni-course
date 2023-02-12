package foods;

import abstraction.Ability;
import abstraction.Food;
import enums.FoodTypeEnum;

public class TransportFood extends Food {

    public TransportFood() {
        super(FoodTypeEnum.TRANSPORT_FOOD);
    }

    @Override
    public void effect(Ability ability) {
        double prevValue = ability.getValue();
        ability.setValue(prevValue + (prevValue / 2));
    }
}
