package abstraction;

import enums.AnimalSpecialTypeEnum;
import enums.AnimalStateEnum;
import exceptions.InvalidAnimalException;
import exceptions.InvalidFoodException;
import utility.Util;

import java.util.List;

import static utility.Util.NEW_LINE;

public class AnimalFarm implements Farm {

    private final AnimalAbilitySaver animalInitAbilitiesSaver;

    public AnimalFarm(){
        animalInitAbilitiesSaver = new AnimalAbilitySaver();
    }

    public void activateAnimalAbility(Animal animal){

        try {
            this.ensureAnimalIsValid(animal);
            this.activateAbilityProcess(animal);
        }
        catch (InvalidAnimalException e){
            Util.printErrorMessage("Животното не е валидно или е null.");
        }
    }

    public void feedAnimal(Animal animal, Food food){

        try {
            this.ensureAnimalIsValid(animal);
            this.ensureFoodIsValid(food);

            if(this.canAnimalEat(animal)){
                animal.eat(food);
            }
        }
        catch (InvalidAnimalException e){
            Util.printErrorMessage("Животното не е валидно или е null.");
        }
        catch (InvalidFoodException e){
            Util.printErrorMessage(e.getMessage());
        }
    }

    public void renderAnimalInformation(Animal animal){

        try {
            this.ensureAnimalIsValid(animal);
            System.out.println(this.buildAnimalInformation(animal));

        }
        catch (InvalidAnimalException e){
            Util.printErrorMessage("Животното не е валидно или е null.");
        }
    }

    private String buildAnimalInformation(Animal animal){
        String animalState = animal.getState().equals(AnimalStateEnum.AWAKE) ?
                "будно състояние" :
                "спящо състояние" ;

        String animalInformation = "Животното " + animal.getCurrentAnimalName() +
                " е в " + animalState +
                NEW_LINE +
                "Тегло: " + animal.getAnimalWeight() +
                NEW_LINE +
                "Скорост: " + animal.getAnimalSpeed() +
                NEW_LINE +
                "Агресия: " + animal.getAnimalAggression() +
                NEW_LINE +
                "Енергия: " + animal.getAnimalStamina();

        return animalInformation;
    }

    private void activateAbilityProcess(Animal animal){

        if(animal.isAnimalOverUseSpecialAbility()){

            animalInitAbilitiesSaver.saveMultipleAbilities(
                    List.of(animal.getWeight(), animal.getSpeed(),
                            animal.getAggression(), animal.getStamina())
            );

            animal.setAnimalStateSleeping();
        }

        animal.activateSpecialAbility();

        if(animal.isStateSleeping()){
            System.out.println("Животното заспа!");
        }

        if(!animal.isAnimalNotSpecial()){
            System.out.println("Специалният ефект е приложен!");
        }
    }

    private boolean canAnimalEat(Animal animal){

        if(!animal.isAnimalNotSpecial()){

            this.devolutionOnAnimal(animal);
            System.out.println("Животното дееволюира до първоначалният си образ!");
            return false;
        }

        if(!animal.isCanAnimalEvolve()) {

            System.out.println("Животното е увредено, НЕ може да еволюира повече!");
            return false;
        }

        if (animal.isAnimalSleepingAndDenying()){

            animal.incrementNumberOfAnimalDenialsToEat();
            System.out.println("Животното не иска да яде в момента.");
            return false;
        }

        if (animal.isAnimalReadyToWakeUp()){

            animal.setAnimalStateAwake();
            this.setAnimalBeforeSleepingAbilities(animal);
            System.out.println("Животното се събуди!");
            return true;
        }

        return true;
    }

    private void setAnimalBeforeSleepingAbilities(Animal animal){

        animal.setAnimalWeight(this.animalInitAbilitiesSaver.restore(animal.getWeight()));
        animal.setAnimalSpeed(this.animalInitAbilitiesSaver.restore(animal.getSpeed()));
        animal.setAnimalStamina(this.animalInitAbilitiesSaver.restore(animal.getStamina()));
        animal.setAnimalAggression(this.animalInitAbilitiesSaver.restore(animal.getAggression()));
    }

    private void devolutionOnAnimal(Animal animal){

        animal.setType(AnimalSpecialTypeEnum.BASIC);
        animal.setCurrentAnimalName(animal.getName());
        animal.setCanAnimalEvolve(false);
    }

    private void ensureAnimalIsValid(Animal animal) throws InvalidAnimalException {
        if(animal == null){
            throw new InvalidAnimalException();
        }
    }

    private void ensureFoodIsValid(Food food) throws InvalidFoodException {
        if(food == null){
            throw new InvalidFoodException();
        }
    }
}