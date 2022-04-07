package moderate.living_people;

public class Person {
    final int birthYear;
    final int deathYear;

    public Person(int birthYear, int deathYear) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
