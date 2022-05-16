package domain.valueobjects;

public class Rating {
    private final int ELO;
    private final int DWZ;

    public Rating(int ELO, int DWZ) {
        this.ELO = ELO;
        this.DWZ = DWZ;
    }

    public int getELO() {
        return ELO;
    }

    public int getDWZ() {
        return DWZ;
    }
}
