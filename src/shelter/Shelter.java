package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal getAnimal = null;
        for (Animal animal : data) {
            if (animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)) {
                getAnimal = animal;
            }
        }
        return getAnimal;
    }

    public Animal getOldestAnimal() {
        Animal getOldest = null;
        int maxAge = Integer.MIN_VALUE;
        for (Animal animal : data) {
            if (animal.getAge() > maxAge) {
                maxAge = animal.getAge();
                getOldest = animal;
            }
        }
        return getOldest;
    }

    public int getCount() {
     return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());
        for (Animal animal : data) {
            sb.append(animal.getName()).append(" ").append(animal.getCaretaker()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
