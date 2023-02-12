package tests;

import abstraction.Animal;
import abstraction.AnimalCreationMachine;
import abstraction.CreationMachine;

public class CreateResetAnimalAbilitiesTest {

    public static void test(){
        testAnimalToResetAbilities();
    }

    private static void testAnimalToResetAbilities(){
        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Animal cow = animalCreationMachine.createCow();
        cow.eatTransportFood();

        cow.activateAnimalSpecialAbilities();
        System.out.println("1ви път: " + cow);

        cow.activateAnimalSpecialAbilities();
        System.out.println("2ри път: " + cow);

        cow.activateAnimalSpecialAbilities();
        System.out.println("3ти път: " + cow);

        System.out.println();
        cow.activateAnimalSpecialAbilities();
        System.out.println("Последен/фатален път: " + cow);
    }
}
