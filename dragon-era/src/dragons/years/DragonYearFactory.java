package dragons.years;

public class DragonYearFactory {
    public DragonYear create(DragonYearType type) {
        switch (type) {
        case NORMAL:
            return new DragonYear(1);
        case BAD:
            return new DragonYear(0);
        case GOOD:
            return new DragonYear(2);
        default:
            throw new UnsupportedOperationException("Year type not supported.");
        }
    }
}
