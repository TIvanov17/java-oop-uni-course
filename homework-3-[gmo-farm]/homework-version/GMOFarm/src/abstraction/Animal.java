package abstraction;

import enums.AnimalStateEnum;
import foods.DeliciousFood;
import foods.FightFood;
import foods.TransportFood;
import utility.RandomGenerator;

import java.util.ArrayList;

abstract public class Animal implements AnimalInterface {

    private static final String NEW_LINE = "\n";
    private static final int MIN_ATTRIBUTE_VALUE = 1;
    private static final int MAX_ATTRIBUTE_VALUE = 10;
    private static final int MAX_SPECIAL_ABILITY_ACTIVATIONS = 3;
    private static final int SLEEPING_ABILITIES = 0;

    private double animalWeight;
    private int animalAggression;
    private double animalSpeed;
    private double animalStamina;
    private AnimalStateEnum animalState;

    private Food animalFoodType;
    private boolean canAnimalEvolve;
    private int numberOfSpecialSkillActivations;
    private int numberOfAnimalDenialsToEat;
    private ArrayList<Object> initialAbilities = new ArrayList<>();

    protected String animalName;
    protected String animalSpecialName;

    public Animal(){
        this.animalWeight = setRandomValueToAnimalAttribute();
        this.animalAggression = setRandomValueToAnimalAttribute();
        this.animalSpeed = setRandomValueToAnimalAttribute();
        this.animalStamina = setRandomValueToAnimalAttribute();
        this.animalState = AnimalStateEnum.AWAKE;
        this.canAnimalEvolve = true;
    }

    public String toString(){
        return "Животното " + this.getAnimalName() +
                " е в " + getAnimalStateVisualisation() +
                NEW_LINE + this.getWeightVisualisation() +
                NEW_LINE + this.getSpeedVisualisation() +
                NEW_LINE + this.getAggressionVisualisation() +
                NEW_LINE + this.getStaminaVisualisation();
    }

    public abstract void setAnimalFightName();

    public abstract void setAnimalTransportName();

    public abstract void setAnimalEatName();

    public abstract String getAnimalUniqueSound();

    public void setAnimalAggression(int animalAggression){
        this.animalAggression = animalAggression;
    }

    public int getAnimalAggression(){
        return this.animalAggression;
    }

    public void eatFightFood(){
        if(!canAnimalEat()){
            return;
        }
        this.animalFoodType = new FightFood(this);
        System.out.println("Животното еволюира до БОЙНО!");
    }

    public void eatTransportFood(){
        if(!canAnimalEat()){
            return;
        }
        this.animalFoodType = new TransportFood(this);
        System.out.println("Животното еволюира до ТРАНСПОРТНО!");
    }

    public void eatDeliciousFood(){
        if(!canAnimalEat()){
            return;
        }
        this.animalFoodType = new DeliciousFood(this);
        System.out.println("Животното еволюира до ХРАНИТЕЛНО!");
    }

    public void activateAnimalSpecialAbilities(){
        if (!getIsAnimalSpecialized()){
            printNonSpecialAnimalSound();
            return;
        }
        if (isAnimalOverUseSpecialAbility()){
            setAnimalStateSleeping();
            return;
        }
        System.out.println("Активирахте специалното умение на животното!");
        this.animalFoodType.foodEffectOnAnimal(this);
        this.numberOfSpecialSkillActivations++;
    }

    public void setAnimalSpeed(double animalSpeed){
        this.animalSpeed = animalSpeed;
    }

    public double getAnimalSpeed(){
        return this.animalSpeed;
    }

    public void setAnimalWeight(double animalWeight){
        this.animalWeight = animalWeight;
    }

    public double getAnimalWeight(){
        return this.animalWeight;
    }

    private boolean canAnimalEat(){
        if(getIsAnimalSpecialized()){
            setIsAnimalSpecialized();
            System.out.println("Животното дееволюира до първоначалният си образ!");
            setAnimalDisabilityToEvolve();
            return false;
        }
        if(!getCanAnimalEvolve()) {
            System.out.println("Животното е увредено, НЕ може да еволюира повече!");
            return false;
        }
        if (isAnimalSleepingAndDenying()){
            System.out.println("Животното не иска да яде в момента.");
            this.numberOfAnimalDenialsToEat++;
            return false;
        }
        if (isAnimalReadyToWakeUp()){
            setAnimalStateAwake();
            return true;
        }
        return true;
    }

    private void setAnimalStateSleeping(){
        System.out.println("Животното заспа!");
        safeInitialAnimalAbilities();
        setAnimalState(AnimalStateEnum.SLEEPING);
        this.animalWeight = SLEEPING_ABILITIES;
        this.animalSpeed = SLEEPING_ABILITIES;
        this.animalAggression = SLEEPING_ABILITIES;
        this.animalStamina = SLEEPING_ABILITIES;
        this.numberOfSpecialSkillActivations = 0;
        setIsAnimalSpecialized();
    }

    private void safeInitialAnimalAbilities() {
        this.initialAbilities.clear();
        this.initialAbilities.add(animalWeight);
        this.initialAbilities.add(animalSpeed);
        this.initialAbilities.add(animalAggression);
        this.initialAbilities.add(animalStamina);
    }
    private void setAnimalStateAwake(){
        System.out.println("Животното се събуди!");
        this.numberOfAnimalDenialsToEat = 0;
        setAnimalState(AnimalStateEnum.AWAKE);
        this.animalWeight = (double) initialAbilities.get(0);
        this.animalSpeed = (double) initialAbilities.get(1);
        this.animalAggression = (int) initialAbilities.get(2);
        this.animalStamina = (double) initialAbilities.get(3);
    }

    private void setAnimalDisabilityToEvolve(){
        this.canAnimalEvolve = false;
    }

    private boolean getCanAnimalEvolve(){
        return this.canAnimalEvolve;
    }

    private void setAnimalState(AnimalStateEnum state){
        this.animalState = state;
    }

    private void setIsAnimalSpecialized(){
        this.animalFoodType = null;
    }

    private boolean getIsAnimalSpecialized(){
        return animalFoodType != null;
    }

    private String getAnimalStateVisualisation(){
        return this.animalState.equals(AnimalStateEnum.AWAKE)?
                "будно състояние" : "спящо състояние";
    }

    private String getWeightVisualisation(){
        return "Тегло: " + this.animalWeight;
    }

    private String getAggressionVisualisation(){
        return "Агресия: " + this.animalAggression;
    }

    private String getSpeedVisualisation(){
        return "Скорост: " + this.animalSpeed;
    }

    private String getStaminaVisualisation(){
        return "Енергия: " + this.animalStamina;
    }

    private void printNonSpecialAnimalSound(){
        System.out.println("Животното " + getAnimalName() +
                " няма специално умение, но то може да издава звук:");
        System.out.println(getAnimalUniqueSound());
    }

    private String getAnimalName() {
        return getIsAnimalSpecialized() ? this.animalSpecialName : this.animalName;
    }

    private int setRandomValueToAnimalAttribute(){
        return RandomGenerator.getRandomNumber
                (MAX_ATTRIBUTE_VALUE, MIN_ATTRIBUTE_VALUE);
    }

    private boolean isAnimalSleepingAndDenying(){
        return this.animalState.equals(AnimalStateEnum.SLEEPING) &&
               this.numberOfAnimalDenialsToEat != 2;
    }

    private boolean isAnimalReadyToWakeUp(){
       return this.numberOfAnimalDenialsToEat == 2;
    }

    private boolean isAnimalOverUseSpecialAbility(){
        return this.numberOfSpecialSkillActivations == MAX_SPECIAL_ABILITY_ACTIVATIONS;
    }
}