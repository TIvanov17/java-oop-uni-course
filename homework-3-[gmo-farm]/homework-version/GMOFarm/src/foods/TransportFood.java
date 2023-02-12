package foods;

import abstraction.Animal;
import abstraction.Food;

public class TransportFood implements Food {

    public TransportFood(Animal animal){
        animal.setAnimalTransportName();
    }

    public void foodEffectOnAnimal(Animal animal){
        double currentAnimalSpeed = animal.getAnimalSpeed();
        double newAnimalSpeed = currentAnimalSpeed + currentAnimalSpeed / 2;
        animal.setAnimalSpeed(newAnimalSpeed);
    }
}