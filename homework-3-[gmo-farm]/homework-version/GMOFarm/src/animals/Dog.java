package animals;

import abstraction.Animal;

public class Dog extends Animal {

    public Dog(){
        super();
        this.animalName = "Куче";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "WOOF WOOF";
    }

    public void setAnimalFightName(){
        this.animalSpecialName = "Бойно куче";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Впрегатно куче";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Виетнамско куче";
    }
}
