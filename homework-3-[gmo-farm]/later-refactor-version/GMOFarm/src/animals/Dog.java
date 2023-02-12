package animals;

import abstraction.Animal;

public class Dog extends Animal {

    public Dog(){
        super("Куче", "Бойно куче",
                "Впрегатно куче", "Виетнамско куче");
    }

    @Override
    public void makeSound() {
        System.out.println("WOOF WOOF");
    }
}
