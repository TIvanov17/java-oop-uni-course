package animals;

import abstraction.Animal;

public class Cock extends Animal {

    public Cock(){
        super();
        this.animalName = "Петел";
    }

    @Override
    public String getAnimalUniqueSound() {
        return "COCK-A-DOODLE-DOO" ;
    }

    public void setAnimalFightName(){
        this.animalSpecialName = "Боен петел";
    }

    @Override
    public void setAnimalTransportName() {
        this.animalSpecialName = "Щраус";
    }

    @Override
    public void setAnimalEatName() {
        this.animalSpecialName = "Печен петел";
    }
}
