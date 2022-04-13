package moderate.Q10_living_people;

import java.util.Random;

public class QuestionC {
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

    public static int maxAliveYear(Person[] people, int minYear, int maxYear) {
        int[] populationDeltas = getPopulationDeltas(people, minYear, maxYear);
        int max = getMaxAliveYear(populationDeltas);
        return max + minYear;
    }

    private static int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] populationDeltas = new int[max - min + 2];
        for (Person person : people) {
            int birth = person.birthYear - min;
            populationDeltas[birth]++;

            int death = person.deathYear - min;
            populationDeltas[death + 1]--;
        }
        return populationDeltas;
    }

    private static int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;
        for (int year = 0; year < deltas.length; year++) {
            currentlyAlive += deltas[year];
            if (currentlyAlive > maxAlive) {
                maxAlive = currentlyAlive;
                maxAliveYear = year;
            }
        }
        return maxAliveYear;
    }

}
