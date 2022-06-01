package T06DefiningClassesExercises.E03SpeedRacing;


public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKM;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKM = fuelCostPerKM;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostPerKM() {
        return fuelCostPerKM;
    }

    public void setFuelCostPerKM(int fuelCostPerKM) {
        this.fuelCostPerKM = fuelCostPerKM;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void calculateMileage(double fuelAmount, double fuelCostPerKM, int distanceTraveled, int amountKilometers) {
        if (fuelAmount >= fuelCostPerKM * amountKilometers) {
            this.distanceTraveled += amountKilometers;
            this.fuelAmount -= fuelCostPerKM * amountKilometers;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
