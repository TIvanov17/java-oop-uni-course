package tests;

import abstraction.*;
import foods.TransportFood;

public class CreateResetAnimalAbilitiesTest {

    public static void test(){
        testAnimalToResetAbilities();
    }

    private static void testAnimalToResetAbilities(){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal cow = animalCreationMachine.createCow();
        Food transportFood = new TransportFood();

        farm.feedAnimal(cow, transportFood);

        System.out.println("1ви път:");

        farm.activateAnimalAbility(cow);
        farm.renderAnimalInformation(cow);

        System.out.println("2ри път:");

        farm.activateAnimalAbility(cow);
        farm.renderAnimalInformation(cow);


        System.out.println("3ти път:");

        farm.activateAnimalAbility(cow);
        farm.renderAnimalInformation(cow);

        farm.activateAnimalAbility(cow);
        System.out.println("Последен/фатален път:");
        farm.renderAnimalInformation(cow);
    }
}
