package easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Egg> data;
    private final String material;
    private final int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg (Egg egg) {
        if (data.size() < this.capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int maxStrength = Integer.MIN_VALUE;
        Egg strongest = null;
        for (Egg egg : data) {
            if (egg.getStrength() > maxStrength) {
                maxStrength = egg.getStrength();
                strongest = egg;
            }
        }
        return strongest;
    }

    public Egg getEgg(String color) {
        Egg egg1 = null;
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
               egg1 = egg;
               break;
            }
        }
        return egg1;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s basket contains: %n", material));
        for (Egg egg : data) {
            builder.append(egg).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
