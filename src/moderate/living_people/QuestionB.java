package moderate.living_people;


import java.util.Arrays;
import java.util.Random;

public class QuestionB {
    public static void main(String[] args) {
        int n = 3;
        int first = 1900;
        int last = 2000;
        Random random = new Random();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            int birth = first + random.nextInt(last - first);
            int death = birth + random.nextInt(last - birth);
            people[i] = new Person(birth, death);
            System.out.println(birth + ", " + death);
        }
        int year = maxAliveYear(people, first, last);
        System.out.println(year);
    }

    public static int maxAliveYear(Person[] personList, int minYear, int maxYear) {
        int[] birthYears = getSortedYears(personList, true);
        int[] deathYears = getSortedYears(personList, false);

        int maxAlive = 0;
        int maxAliveYear = minYear;
        int currentlyAlive = 0;
        int birthYearIndex = 0;
        int deathYearIndex = 0;
        while (birthYearIndex < birthYears.length) {
            if (birthYears[birthYearIndex] <= deathYears[deathYearIndex]) {
                currentlyAlive++;
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = birthYears[birthYearIndex];
                }
                birthYearIndex++;
            } else {
                currentlyAlive--;
                deathYearIndex++;
            }
        }
        return maxAliveYear;
    }

    static int[] getSortedYears(Person[] people, boolean birthYears) {
        int[] years = new int[people.length];
        int index = 0;
        for (Person person : people) {
            int year = birthYears ? person.birthYear : person.deathYear;
            years[index++] = year;
        }
        Arrays.sort(years);
        return years;
    }
}
