package moderate.Q19_pond_sizes;

import java.util.Objects;

public class Index {
    int row, column;

    public Index(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Index minusColumn(int i) {
        return new Index(row, column - i);
    }

    public Index minusRow(int i) {
        return new Index(row - i, column);
    }

    public Index plusColumn(int i) {
        return new Index(row, column + i);
    }

    public Index plusRow(int i) {
        return new Index(row + i, column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return row == index.row && column == index.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
