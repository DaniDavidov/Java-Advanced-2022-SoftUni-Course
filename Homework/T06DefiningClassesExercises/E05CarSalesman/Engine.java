package T06DefiningClassesExercises.E05CarSalesman;

public class Engine {
    String model;
    int power;
    String displacements;
    String efficiency;

    public Engine(String model, int power, String displacements, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacements = displacements;
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n", this.model, this.power, this.displacements, this.efficiency);
    }

    public String getDisplacements() {
        return displacements;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
