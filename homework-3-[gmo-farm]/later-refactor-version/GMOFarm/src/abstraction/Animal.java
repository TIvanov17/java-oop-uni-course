package abstraction;

import enums.AnimalSpecialTypeEnum;
import enums.AnimalStateEnum;

public abstract class Animal {

    private static final int MAX_SPECIAL_ABILITY_ACTIVATIONS = 3;

    private final String name;
    private final String fightName;
    private final String transportName;
    private final String eatName;
    private String currentAnimalName;

    private final Ability weight;
    private final Ability speed;
    private final Ability stamina;
    private final Ability aggression;

    private AnimalStateEnum state;
    private AnimalSpecialTypeEnum type;

    private Food lastEatenFood;
    private boolean canAnimalEvolve;
    private int numberOfAnimalDenialsToEat;
    private int numberOfSpecialSkillActivations;

    public Animal(String name, String fightName, String transportName, String eatName){

        this.name = name;
        this.fightName = fightName;
        this.transportName = transportName;
        this.eatName = eatName;
        this.currentAnimalName = this.name;

        this.weight = new Ability("weight");
        this.speed = new Ability("speed");
        this.stamina = new Ability("stamina");
        this.aggression = new Ability("aggression");

        this.state = AnimalStateEnum.AWAKE;
        this.type = AnimalSpecialTypeEnum.BASIC;
        this.canAnimalEvolve = true;
    }
    public abstract void makeSound();

    public boolean isStateSleeping(){
        return this.state.equals(AnimalStateEnum.SLEEPING);
    }

    public String getName() {
        return this.name;
    }

    public String getCurrentAnimalName(){
        return this.currentAnimalName;
    }

    public AnimalStateEnum getState() {
        return state;
    }

    public void setType(AnimalSpecialTypeEnum type) {
        this.type = type;
    }

    public void incrementNumberOfAnimalDenialsToEat() {
        this.numberOfAnimalDenialsToEat++;
    }

    public boolean isCanAnimalEvolve() {
        return canAnimalEvolve;
    }

    public void setCanAnimalEvolve(boolean canAnimalEvolve) {
        this.canAnimalEvolve = canAnimalEvolve;
    }

    public void setCurrentAnimalName(String currentAnimalName) {
        this.currentAnimalName = currentAnimalName;
    }

    public double getAnimalWeight() {
        return this.weight.getValue();
    }

    public double getAnimalSpeed() {
        return this.speed.getValue();
    }

    public double getAnimalStamina() {
        return this.stamina.getValue();
    }

    public double getAnimalAggression() {
        return this.aggression.getValue();
    }

    public void setAnimalWeight(double value) {
        this.weight.setValue(value);
    }

    public void setAnimalSpeed(double value) {
        this.speed.setValue(value);
    }

    public void setAnimalStamina(double value) {
        this.stamina.setValue(value);
    }

    public void setAnimalAggression(double value) {
        this.aggression.setValue(value);
    }

    protected void activateSpecialAbility(){

        if (this.isAnimalNotSpecial()){
            this.makeSound();
            return;
        }

        this.applyAnimalEatenFood();
    }

    protected void eat(Food food){

        if(food.isFightFood()){
            this.type = AnimalSpecialTypeEnum.FOR_FIGHT;
            this.currentAnimalName = this.fightName;
        }
        else if(food.isTransportFood()){
            this.type = AnimalSpecialTypeEnum.FOR_TRANSPORT;
            this.currentAnimalName = this.transportName;
        }
        else if(food.isNutritionalFood()){
            this.type = AnimalSpecialTypeEnum.FOR_EAT;
            this.currentAnimalName = this.eatName;
        }

        this.lastEatenFood = food;
    }

    protected boolean isAnimalSleepingAndDenying(){
        return this.state.equals(AnimalStateEnum.SLEEPING) && this.numberOfAnimalDenialsToEat != 2;
    }

    protected boolean isAnimalReadyToWakeUp(){
        return this.numberOfAnimalDenialsToEat == 2;
    }

    protected Ability getWeight() {
        return weight;
    }

    protected Ability getSpeed() {
        return speed;
    }

    protected Ability getStamina() {
        return stamina;
    }

    protected Ability getAggression() {
        return aggression;
    }

    protected void setAnimalStateAwake(){

        this.numberOfAnimalDenialsToEat = 0;
        this.state = AnimalStateEnum.AWAKE;
    }

    protected boolean isAnimalOverUseSpecialAbility(){
        return this.numberOfSpecialSkillActivations == MAX_SPECIAL_ABILITY_ACTIVATIONS;
    }

    protected boolean isAnimalNotSpecial(){
        return type.equals(AnimalSpecialTypeEnum.BASIC);
    }

    protected void setAnimalStateSleeping(){
        this.currentAnimalName = this.name;
        this.state = AnimalStateEnum.SLEEPING;
        this.type = AnimalSpecialTypeEnum.BASIC;

        this.weight.setAbilityValueToZero();
        this.speed.setAbilityValueToZero();
        this.aggression.setAbilityValueToZero();
        this.stamina.setAbilityValueToZero();

        this.numberOfSpecialSkillActivations = 0;
    }

    private void applyAnimalEatenFood(){
        this.applyFoodEffect();
        this.numberOfSpecialSkillActivations++;
    }

    private void applyFoodEffect(){

        if(this.lastEatenFood.isFightFood()){
            this.lastEatenFood.effect(aggression);
            return;
        }

        if(this.lastEatenFood.isTransportFood()){
            this.lastEatenFood.effect(speed);
        }

        if(this.lastEatenFood.isNutritionalFood()){
            this.lastEatenFood.effect(weight);
        }
    }
}