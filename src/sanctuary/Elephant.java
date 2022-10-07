package sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    public int getAge() {
        return age;
    }
}