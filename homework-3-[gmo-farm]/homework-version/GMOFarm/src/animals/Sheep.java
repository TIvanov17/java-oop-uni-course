package animals;

import abstraction.Animal;

public class Sheep extends Animal {

    public Sheep(){
        super();
        this.animalName = "Овца";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "BAA";
    }

    @Override
    public void setAnimalFightName() {
        this.animalSpecialName = "Бойна овца";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Бърза овца";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Млекодайна овца";
    }
}
