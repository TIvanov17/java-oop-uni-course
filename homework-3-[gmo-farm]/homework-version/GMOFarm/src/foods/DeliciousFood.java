package foods;

import abstraction.Animal;
import abstraction.Food;

public class DeliciousFood implements Food {

    public DeliciousFood(Animal animal) {
        animal.setAnimalEatName();
    }

    @Override
    public void foodEffectOnAnimal(Animal animal) {
        double currentAnimalWeight = animal.getAnimalWeight();
        double newAnimalWeight = currentAnimalWeight + (currentAnimalWeight * 0.1);
        animal.setAnimalWeight(newAnimalWeight);
    }
}