package tests;

import abstraction.*;

public class CreateBasicAnimalTest {

    public static void test() {

        System.out.println("Крава Тест 1:");
        testCowAsLivingCreature();
        System.out.println();

        System.out.println("Овца Тест 2:");
        testSheepAsLivingCreature();
        System.out.println();

        System.out.println("Петел Тест 3:");
        testCockAsLivingCreature();
        System.out.println();

        System.out.println("Кон Тест 4:");
        testHorseAsLivingCreature();
        System.out.println();

        System.out.println("Куче Тест 5:");
        testDogAsLivingCreature();
        System.out.println();

        System.out.println("Камила Тест 6:");
        testCamelAsLivingCreature();
        System.out.println();
    }

    private static void testCowAsLivingCreature() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal cow = animalCreationMachine.createCow();
        farm.renderAnimalInformation(cow);
        farm.activateAnimalAbility(cow);

    }

    private static void testSheepAsLivingCreature() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal sheep = animalCreationMachine.createSheep();
        farm.renderAnimalInformation(sheep);
        farm.activateAnimalAbility(sheep);
    }

    private static void testCockAsLivingCreature() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal cock = animalCreationMachine.createCock();
        farm.renderAnimalInformation(cock);
        farm.activateAnimalAbility(cock);
    }

    private static void testHorseAsLivingCreature(){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal horse = animalCreationMachine.createHorse();
        farm.renderAnimalInformation(horse);
        farm.activateAnimalAbility(horse);
    }

    private static void testDogAsLivingCreature() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal dog = animalCreationMachine.createDog();
        farm.renderAnimalInformation(dog);
        farm.activateAnimalAbility(dog);

    }

    private static void testCamelAsLivingCreature() {

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();

        Animal camel = animalCreationMachine.createCamel();
        farm.renderAnimalInformation(camel);
        farm.activateAnimalAbility(camel);

    }
}