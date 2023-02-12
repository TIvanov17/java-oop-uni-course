package animals;

import abstraction.Animal;

public class Cow extends Animal {

    public Cow(){
        super("Крава","Рогата Крава",
                "Транспортна крава", "Млекодайна крава");
    }

    @Override
    public void makeSound() {
        System.out.println("Moo!");
    }
}
