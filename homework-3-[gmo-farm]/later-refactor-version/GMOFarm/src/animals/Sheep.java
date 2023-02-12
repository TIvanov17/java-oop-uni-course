package animals;

import abstraction.Animal;

public class Sheep extends Animal {

    public Sheep(){
        super("Овца", "Бойна овца",
                "Бърза овца", "Млекодайна овца");
    }

    @Override
    public void makeSound() {
        System.out.println("BAA");
    }
}
