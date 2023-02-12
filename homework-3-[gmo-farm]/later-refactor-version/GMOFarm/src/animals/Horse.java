package animals;

import abstraction.Animal;

public class Horse extends Animal {

    public Horse(){
        super("Кон", "Боен кон",
                "Кон Вихрогон", "Дебел кон");
    }

    @Override
    public void makeSound() {
        System.out.println("NEIGH");
    }
}
