package Player;

import exceptions.InvalidPlayerNameExeption;

import java.util.Objects;

public final class PlayerName {
    final String lastName;
    final String firstName;

    public PlayerName(String firstName, String lastName) throws InvalidPlayerNameExeption {
        this.firstName = firstName;
        this.lastName = lastName;
        if (this.lastName == null || this.firstName == null)
            throw new InvalidPlayerNameExeption();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return lastName + ", " + firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName name = (PlayerName) o;
        return lastName.equals(name.lastName) && firstName.equals(name.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
