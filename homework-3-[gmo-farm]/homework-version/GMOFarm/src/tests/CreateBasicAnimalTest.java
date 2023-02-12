package tests;

import abstraction.Animal;
import abstraction.AnimalCreationMachine;
import abstraction.CreationMachine;

public class CreateBasicAnimalTest {

    public static void test() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();

        System.out.println("Крава Тест 1:");
        testCowAsLivingCreature(animalCreationMachine);
        System.out.println();
        System.out.println("Овца Тест 2:");
        testSheepAsLivingCreature(animalCreationMachine);
        System.out.println();
        System.out.println("Петел Тест 3:");
        testCockAsLivingCreature(animalCreationMachine);
        System.out.println();
        System.out.println("Кон Тест 4:");
        testHorseAsLivingCreature(animalCreationMachine);
        System.out.println();
        System.out.println("Куче Тест 5:");
        testDogAsLivingCreature(animalCreationMachine);
        System.out.println();
        System.out.println("Камила Тест 6:");
        testCamelAsLivingCreature(animalCreationMachine);
        System.out.println();

    }

    private static void testCowAsLivingCreature(CreationMachine animalCreationMachine) {
        Animal cow = animalCreationMachine.createCow();
        System.out.println(cow);
        cow.activateAnimalSpecialAbilities();
    }

    private static void testSheepAsLivingCreature(CreationMachine animalCreationMachine) {
        Animal sheep = animalCreationMachine.createSheep();
        System.out.println(sheep);
        sheep.activateAnimalSpecialAbilities();
    }

    private static void testCockAsLivingCreature(CreationMachine animalCreationMachine) {
        Animal cock = animalCreationMachine.createCock();
        System.out.println(cock);
        cock.activateAnimalSpecialAbilities();
    }

    private static void testHorseAsLivingCreature(CreationMachine animalCreationMachine){
        Animal horse = animalCreationMachine.createHorse();
        System.out.println(horse);
        horse.activateAnimalSpecialAbilities();
    }

    private static void testDogAsLivingCreature(CreationMachine animalCreationMachine) {
        Animal dog = animalCreationMachine.createDog();
        System.out.println(dog);
        dog.activateAnimalSpecialAbilities();
    }

    private static void testCamelAsLivingCreature(CreationMachine animalCreationMachine) {
        Animal camel = animalCreationMachine.createCamel();
        System.out.println(camel);
        camel.activateAnimalSpecialAbilities();
    }
}