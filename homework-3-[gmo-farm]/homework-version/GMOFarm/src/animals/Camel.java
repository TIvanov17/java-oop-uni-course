package animals;

import abstraction.Animal;

public class Camel extends Animal {

    public Camel(){
        super();
        this.animalName = "Камила";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "Some Camel Sound";
    }

    public void setAnimalFightName(){
        this.animalSpecialName = "Плюеща камила";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Двугърба камила";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Вкусна камила";
    }
}
