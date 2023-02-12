package tests;

import abstraction.Animal;
import abstraction.AnimalCreationMachine;
import abstraction.CreationMachine;

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
        Animal animal = currentAnimal;
        System.out.println(animal);
        animal.eatDeliciousFood();
        animal.eatFightFood();
        System.out.println(animal);
    }
}
