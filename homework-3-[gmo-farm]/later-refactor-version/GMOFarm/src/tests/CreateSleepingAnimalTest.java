package tests;

import abstraction.*;
import foods.FightFood;

public class CreateSleepingAnimalTest {

    public static void test(){
        testSleepingAnimal();
    }

    private static void testSleepingAnimal(){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal cow = animalCreationMachine.createCow();
        Food fightFood = new FightFood();

        farm.feedAnimal(cow, fightFood);

        farm.activateAnimalAbility(cow);
        System.out.println("1ви път:");
        farm.renderAnimalInformation(cow);

        farm.activateAnimalAbility(cow);
        System.out.println("2ри път:");
        farm.renderAnimalInformation(cow);

        farm.activateAnimalAbility(cow);
        System.out.println("3ти път:");
        farm.renderAnimalInformation(cow);

        farm.activateAnimalAbility(cow);
        System.out.println();
        System.out.println("Последен/фатален път:");
        farm.renderAnimalInformation(cow);

        farm.feedAnimal(cow, fightFood);
        farm.feedAnimal(cow, fightFood);
        farm.feedAnimal(cow, fightFood);

        farm.activateAnimalAbility(cow);
        System.out.println("След сън:");
        farm.renderAnimalInformation(cow);

    }
}