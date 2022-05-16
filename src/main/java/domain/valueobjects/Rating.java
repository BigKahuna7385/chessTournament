package domain.valueobjects;

public final class Rating {
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

    @Override
    public int hashCode() {
        return Integer.getInteger("" + getELO() + getDWZ());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Rating rating = (Rating) obj;
        return getELO() == rating.getELO() && getDWZ() == rating.getDWZ();
    }
}
