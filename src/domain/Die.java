package domain;

import java.util.Random;

public class Die {
    private int sides;
    private Random random;

    public Die(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}

