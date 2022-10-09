package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    public String name;
    public int capacity;
    public List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
       for (Parrot parrot: data) {
           if (parrot.getName().equals(name)) {
               data.remove(parrot);
               return true;
           }
       }
       return false;
    }

    public Parrot sellParrot(String name) {
        Parrot parrotToSale = null;
        for (var parrot : data) {
            if (parrot.isAvailable() && parrot.getName().equals(name)) {
                parrot.setAvailable();
                parrotToSale = parrot;
            }
        }
        return parrotToSale;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List <Parrot> parrotsToSale = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.isAvailable() && parrot.getSpecies().equals(species)) {
                parrotsToSale.add(parrot);
                parrot.setAvailable();
            }
        }
        return parrotsToSale;
    }

    public int count() {
        return data.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", name)).append(System.lineSeparator());
        for (Parrot parrot : data) {
            if (parrot.isAvailable()) {
                builder.append(parrot).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
