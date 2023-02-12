package animals;

import abstraction.Animal;

public class Cow extends Animal {

    public Cow(){
        super();
        this.animalName = "Крава";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "Moo!";
    }

    public void setAnimalFightName(){
        this.animalSpecialName = "Рогата Крава";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Транспортна крава";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Млекодайна крава";
    }
}
