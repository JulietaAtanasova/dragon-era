package dragons.years;

public class YearFactory {
    public Year create(YearType type) {
        switch (type) {
        case NORMAL:
            return new Year(1);
        case BAD:
            return new Year(0);
        case GOOD:
            return new Year(2);
        default:
            throw new UnsupportedOperationException("Year type not supported.");
        }
    }
}
