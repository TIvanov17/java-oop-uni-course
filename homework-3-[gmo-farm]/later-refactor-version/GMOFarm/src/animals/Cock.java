package animals;

import abstraction.Animal;

public class Cock extends Animal {

    public Cock(){
        super("Петел", "Боен петел",
                "Щраус", "Печен петел");

    }

    @Override
    public void makeSound() {
        System.out.println("COCK-A-DOODLE-DOO");
    }
}
