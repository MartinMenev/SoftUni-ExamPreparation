package sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        this.capacity--;
        if (capacity > 0) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                data.remove(elephant);
                capacity++;
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant () {
        int maxAge = Integer.MIN_VALUE;
        Elephant oldestElephant = null;
        for (Elephant elephant : data) {
            if (elephant.getAge() > maxAge) {
                maxAge = elephant.getAge();
                oldestElephant = elephant;
            }
        }
        return oldestElephant;
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:" + "\n");
        data.forEach(e -> report.append(e.getName()).append(" came from: ").append(e.getRetiredFrom()).append("\n"));
        return report.toString();
    }

}
