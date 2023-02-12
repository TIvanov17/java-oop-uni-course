package abstraction;

import animals.*;

public class AnimalCreationMachine implements CreationMachine {

    public Animal createCow(){
        return new Cow();
    }

    public Animal createCock(){
        return new Cock();
    }

    public Animal createCamel(){
        return new Camel();
    }

    public Animal createDog(){
        return new Dog();
    }

    public Animal createHorse(){
        return new Horse();
    }

    public Animal createSheep(){
        return new Sheep();
    }
}