package Player;

import exceptions.InvalidListNumberException;

import java.util.Objects;

public final class ListNumber {
    final int listNumber;

    public ListNumber(int listNumber) throws InvalidListNumberException {
        this.listNumber = listNumber;
        if (this.listNumber < 0)
            throw new InvalidListNumberException();
    }

    public int getListNumber() {
        return listNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNumber that = (ListNumber) o;
        return listNumber == that.listNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(listNumber);
    }
}
