package animals;

import abstraction.Animal;

public class Camel extends Animal {

    public Camel(){
        super("Камила","Плюеща камила",
                "Двугърба камила", "Вкусна камила");
    }

    @Override
    public void makeSound() {
        System.out.println("Camel, but not Case...");
    }
}
