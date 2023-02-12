package tests;

import abstraction.*;
import foods.FightFood;
import foods.NutritionalFood;

public class CreateMultipleAnimalEvolutionTest {

    public static void test(){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();

        testAnimalMultipleEvolution(animalCreationMachine.createCow());
        System.out.println();
        testAnimalMultipleEvolution(animalCreationMachine.createCamel());
        System.out.println();
        testAnimalMultipleEvolution(animalCreationMachine.createCock());
        System.out.println();
        testAnimalMultipleEvolution(animalCreationMachine.createSheep());
        System.out.println();
        testAnimalMultipleEvolution(animalCreationMachine.createDog());
        System.out.println();
        testAnimalMultipleEvolution(animalCreationMachine.createHorse());
    }

    private static void testAnimalMultipleEvolution(Animal currentAnimal){

        Farm farm = new AnimalFarm();

        Food nutritionalFood = new NutritionalFood();
        Food fightFood = new FightFood();

        farm.renderAnimalInformation(currentAnimal);
        farm.feedAnimal(currentAnimal, nutritionalFood);

        farm.feedAnimal(currentAnimal, fightFood);

        farm.renderAnimalInformation(currentAnimal);
    }
}
