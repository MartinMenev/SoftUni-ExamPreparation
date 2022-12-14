package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet getPet = null;
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                getPet = pet;
            }
        }
        return getPet;
    }

    public Pet getOldestPet() {
        Pet oldestPet = null;
        int maxAge = Integer.MIN_VALUE;
        for (Pet pet : data) {
            if (pet.getAge() > maxAge) {
                maxAge = pet.getAge();
                oldestPet = pet;
            }
        }
        return oldestPet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
