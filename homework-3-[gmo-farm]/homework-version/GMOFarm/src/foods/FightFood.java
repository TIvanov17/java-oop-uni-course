package foods;

import abstraction.Animal;
import abstraction.Food;

public class FightFood implements Food {

    public FightFood(Animal animal){
        animal.setAnimalFightName();
    }

    public void foodEffectOnAnimal(Animal animal){
        int currentAggression = animal.getAnimalAggression();
        animal.setAnimalAggression(currentAggression + 1);
    }
}