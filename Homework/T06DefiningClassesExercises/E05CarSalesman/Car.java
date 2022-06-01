package T06DefiningClassesExercises.E05CarSalesman;

public class Car {
    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n%sWeight: %s%nColor: %s%n", this.model, this.engine.toString(), this.weight, this.color);
    }
}
