package sorting_searching.sorted_search;

public class Listy {
    private final int[] elements;

    public Listy(int[] elements) {
        this.elements = elements.clone();
    }

    public int elementAt(int index) {
        if (index >= elements.length) {
            return -1;
        }
        return elements[index];
    }
}
