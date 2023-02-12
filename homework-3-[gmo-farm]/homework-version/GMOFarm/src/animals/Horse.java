package animals;

import abstraction.Animal;

public class Horse extends Animal {

    public Horse(){
        super();
        this.animalName = "Кон";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "NEIGH";
    }

    public void setAnimalFightName(){
        this.animalSpecialName = "Боен кон";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Кон Вихрогон";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Дебел кон";
    }
}
