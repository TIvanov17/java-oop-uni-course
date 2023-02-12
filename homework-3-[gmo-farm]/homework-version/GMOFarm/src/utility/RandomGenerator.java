package utility;

import java.util.Random;

abstract public class RandomGenerator {

    public static int getRandomNumber(int upperBound, int lowerBound){
        Random rand = new Random();
        return rand.nextInt(upperBound) + lowerBound;

    }
}
