package domain.valueobjects;

public final class Name {
    private final String lastName;
    private final String firstName;

    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Name name = (Name) obj;
        return getFirstName().equals(name.getFirstName()) && getLastName().equals(name.getLastName());
    }
}
