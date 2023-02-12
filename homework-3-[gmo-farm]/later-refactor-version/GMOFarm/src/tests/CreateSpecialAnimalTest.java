package tests;

import abstraction.*;
import enums.AnimalSpecialTypeEnum;
import foods.FightFood;
import foods.NutritionalFood;
import foods.TransportFood;

public class CreateSpecialAnimalTest {

    public static void test(){
        System.out.println("БОЙНИ");
        System.out.println();
        testSpecialAnimal(AnimalSpecialTypeEnum.FOR_FIGHT);
        System.out.println("ТРАНСПОРТНИ");
        System.out.println();
        testSpecialAnimal(AnimalSpecialTypeEnum.FOR_TRANSPORT);
        System.out.println("ХРАНИТЕЛНИ");
        System.out.println();
        testSpecialAnimal(AnimalSpecialTypeEnum.FOR_EAT);
    }

    public static void testSpecialAnimal(AnimalSpecialTypeEnum type){

        testCowAsSpecializedAnimal(type);
        System.out.println();
        testSheepAsSpecializedAnimal(type);
        System.out.println();
        testCockAsSpecializedAnimal(type);
        System.out.println();
        testHorseAsSpecializedAnimal(type);
        System.out.println();
        testDogAsSpecializedAnimal(type);
        System.out.println();
        testCamelAsSpecializedAnimal(type);
        System.out.println();
    }

    private static void testCowAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal cow = animalCreationMachine.createCow();

        System.out.println("Преди:");
        farm.renderAnimalInformation(cow);

        eatFoodByAnimalType(cow, type);
        farm.activateAnimalAbility(cow);
        //cow.activateSpecialAbility();

        System.out.println("След:");
        farm.renderAnimalInformation(cow);
    }

    private static void testSheepAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal sheep = animalCreationMachine.createSheep();

        System.out.println("Преди:");
        farm.renderAnimalInformation(sheep);

        eatFoodByAnimalType(sheep, type);
        farm.activateAnimalAbility(sheep);
        //sheep.activateSpecialAbility();

        System.out.println("След:");
        farm.renderAnimalInformation(sheep);
    }

    private static void testCockAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal cock = animalCreationMachine.createCock();

        System.out.println("Преди:");
        farm.renderAnimalInformation(cock);

        eatFoodByAnimalType(cock, type);
        farm.activateAnimalAbility(cock);
        //cock.activateSpecialAbility();

        System.out.println("След:");
        farm.renderAnimalInformation(cock);
    }

    private static void testHorseAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal horse = animalCreationMachine.createHorse();

        System.out.println("Преди:");
        farm.renderAnimalInformation(horse);

        eatFoodByAnimalType(horse, type);
        farm.activateAnimalAbility(horse);

        System.out.println("След:");
        farm.renderAnimalInformation(horse);
    }

    private static void testDogAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal dog = animalCreationMachine.createDog();

        System.out.println("Преди:");
        farm.renderAnimalInformation(dog);

        eatFoodByAnimalType(dog, type);
        farm.activateAnimalAbility(dog);

        System.out.println("След:");
        farm.renderAnimalInformation(dog);
    }

    private static void testCamelAsSpecializedAnimal(AnimalSpecialTypeEnum type){

        CreationMachine animalCreationMachine = new AnimalCreationMachine();
        Farm farm = new AnimalFarm();
        Animal camel = animalCreationMachine.createCamel();

        System.out.println("Преди:");
        farm.renderAnimalInformation(camel);

        eatFoodByAnimalType(camel, type);
        farm.activateAnimalAbility(camel);


        System.out.println("След:");
        farm.renderAnimalInformation(camel);
    }

    private static void eatFoodByAnimalType(Animal animal, AnimalSpecialTypeEnum type){

        Farm farm  = new AnimalFarm();

        if (type.equals(AnimalSpecialTypeEnum.FOR_FIGHT)) {
            farm.feedAnimal(animal, new FightFood());
            return;
        }
        if(type.equals(AnimalSpecialTypeEnum.FOR_TRANSPORT)){
            farm.feedAnimal(animal, new TransportFood());
            return;
        }

        farm.feedAnimal(animal, new NutritionalFood());
    }
}