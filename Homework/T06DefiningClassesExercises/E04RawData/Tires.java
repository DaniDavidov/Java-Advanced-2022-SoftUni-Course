package T06DefiningClassesExercises.E04RawData;

import java.util.List;

public class Tires {
    List<Tire> tires;

    public Tires(List<Tire> tires) {
        this.tires = tires;
    }
    public boolean hasGoodTireCondition() {
        for (Tire tire : tires) {
            if (tire.getTirePressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
