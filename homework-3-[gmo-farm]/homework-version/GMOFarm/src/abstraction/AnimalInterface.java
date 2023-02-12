package abstraction;

import foods.DeliciousFood;
import foods.FightFood;
import foods.TransportFood;

public interface AnimalInterface {

    void setAnimalWeight(double animalWeight);

    double getAnimalWeight();

    void setAnimalSpeed(double animalSpeed);

    double getAnimalSpeed();

    void setAnimalAggression(int animalAggression);

    int getAnimalAggression();

    void eatFightFood();

    void eatTransportFood();

    void eatDeliciousFood();
}
