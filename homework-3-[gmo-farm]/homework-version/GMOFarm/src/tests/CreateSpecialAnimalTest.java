package tests;

import abstraction.Animal;
import abstraction.AnimalCreationMachine;
import abstraction.CreationMachine;
import enums.AnimalSpecialTypeEnum;

public class CreateSpecialAnimalTest {

    public static void test(){
        System.out.println("БОЙНИ");
        testSpecialAnimal(AnimalSpecialTypeEnum.FIGHT_ANIMAL);
        System.out.println("ТРАНСПОРТНИ");
        testSpecialAnimal(AnimalSpecialTypeEnum.TRANSPORT_ANIMAL);
        System.out.println("ХРАНИТЕЛНИ");
        testSpecialAnimal(AnimalSpecialTypeEnum.EAT_ANIMAL);
    }

    public static void testSpecialAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();

        testCowAsSpecializedAnimal(animalCreationMachine, type);
        System.out.println();
        testSheepAsSpecializedAnimal(animalCreationMachine,type);
        System.out.println();
        testCockAsSpecializedAnimal(animalCreationMachine, type);
        System.out.println();
        testHorseAsSpecializedAnimal(animalCreationMachine, type);
        System.out.println();
        testDogAsSpecializedAnimal(animalCreationMachine, type);
        System.out.println();
        testCamelAsSpecializedAnimal(animalCreationMachine, type);
        System.out.println();
    }

    private static void testCowAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal cow = animalCreationMachine.createCow();
        System.out.println("Преди: " + cow);
        eatFoodByAnimalType(cow, type);
        cow.activateAnimalSpecialAbilities();
        System.out.println("След: " + cow);
    }

    private static void testSheepAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal sheep = animalCreationMachine.createSheep();
        System.out.println("Преди: " + sheep);
        eatFoodByAnimalType(sheep, type);
        sheep.activateAnimalSpecialAbilities();
        System.out.println("След: " + sheep);
    }

    private static void testCockAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal cock = animalCreationMachine.createCock();
        System.out.println("Преди: " + cock);
        eatFoodByAnimalType(cock, type);
        cock.activateAnimalSpecialAbilities();
        System.out.println("След: " + cock);
    }

    private static void testHorseAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal horse = animalCreationMachine.createHorse();
        System.out.println("Преди: " + horse);
        eatFoodByAnimalType(horse, type);
        horse.activateAnimalSpecialAbilities();
        System.out.println("След: " + horse);
    }

    private static void testDogAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal dog = animalCreationMachine.createDog();
        System.out.println("Преди: " + dog);
        eatFoodByAnimalType(dog, type);
        dog.activateAnimalSpecialAbilities();
        System.out.println("След: " + dog);
    }

    private static void testCamelAsSpecializedAnimal
            (CreationMachine animalCreationMachine,AnimalSpecialTypeEnum type){

        Animal camel = animalCreationMachine.createCamel();
        System.out.println("Преди: " + camel);
        eatFoodByAnimalType(camel, type);
        camel.activateAnimalSpecialAbilities();
        System.out.println("След: " + camel);
    }

    private static void eatFoodByAnimalType(Animal animal, AnimalSpecialTypeEnum type){
        if (type.equals(AnimalSpecialTypeEnum.FIGHT_ANIMAL)) {
            animal.eatFightFood();
            return;
        }
        if(type.equals(AnimalSpecialTypeEnum.TRANSPORT_ANIMAL)){
            animal.eatTransportFood();
            return;
        }
        animal.eatDeliciousFood();
    }
}