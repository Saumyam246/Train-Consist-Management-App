public class Bogie {

    private String name;
    private int capacity;
    private double weight;

    public Bogie(String name, int capacity, double weight) {
        this.name = name;
        this.capacity = capacity;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " -> " + weight + " tons";
    }
}