import tests.*;

public class Application {

    public static void main(String[] args){
        System.out.println("Задължителен тест 1");
        System.out.println();
        CreateBasicAnimalTest.test();

        System.out.println("Задължителен тест 2");
        System.out.println();
        CreateSpecialAnimalTest.test();
        System.out.println("Задължителен тест 3");
        System.out.println();
        CreateMultipleAnimalEvolutionTest.test();
        System.out.println("Специален тест 1");
        System.out.println();
        CreateSleepingAnimalTest.test();
        System.out.println("Специален тест 2");
        System.out.println();
        CreateResetAnimalAbilitiesTest.test();

    }
}