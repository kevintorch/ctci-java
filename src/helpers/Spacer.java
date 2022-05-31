package helpers;

import java.util.Iterator;

public class Spacer implements Iterable<String> {
    private final int size;

    public Spacer(int size) {
        this.size = size;
    }

    @Override
    public Iterator<String> iterator() {
        return new SpaceItr();
    }

    class SpaceItr implements Iterator<String> {
        int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public String next() {
            count++;
            return " ";
        }
    }
}
