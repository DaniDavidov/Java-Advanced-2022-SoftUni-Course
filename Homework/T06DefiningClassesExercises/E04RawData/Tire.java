package T06DefiningClassesExercises.E04RawData;

public class Tire {
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }
    public double getTirePressure() {
        return tirePressure;
    }
}

