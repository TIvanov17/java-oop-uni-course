package tests;

import abstraction.Animal;
import abstraction.AnimalCreationMachine;
import abstraction.CreationMachine;

public class CreateSleepingAnimalTest {

    public static void test(){
        testSleepingAnimal();
    }

    private static void testSleepingAnimal(){
        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Animal cow = animalCreationMachine.createCow();
        cow.eatFightFood();

        cow.activateAnimalSpecialAbilities();
        System.out.println("1ви път: " + cow);

        cow.activateAnimalSpecialAbilities();
        System.out.println("2ри път: " + cow);

        cow.activateAnimalSpecialAbilities();
        System.out.println("3ти път: " + cow);

        System.out.println();
        cow.activateAnimalSpecialAbilities();
        System.out.println("Последен/фатален път: " + cow);
        cow.eatFightFood();
        cow.eatFightFood();
        cow.eatFightFood();
        cow.activateAnimalSpecialAbilities();
        System.out.println("След сън: " + cow);
    }
}