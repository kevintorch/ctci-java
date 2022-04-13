package moderate.Q10_living_people;


//  Given a list of people with their birth and death years, implement a method to compute the year
//  with the most number of people alive. You may assume that all people were born between 1900 and 2000 (inclusive).
//  If a person was alive during any portion of that year, they should be included in that year's count.
//  For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        int n = 100;
        int low = 1900;
        int high = 2000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int birthYear = random.nextInt(low, high + 1);
            int deathYear = random.nextInt(birthYear, high + 1);
            personList.add(new Person(birthYear, deathYear));
        }
        personList.forEach(person -> System.out.println(person.toString()));
        int maxAliveYear = maxAliveYear(personList, low, high);
        int maxAliveYear2 = maxAliveYear2(personList.toArray(Person[]::new), low, high);
        System.out.println("maxAliveYear: " + maxAliveYear);
        System.out.println("maxAliveYear2: " + maxAliveYear2);
    }

    public static int maxAliveYear(List<Person> personList, int lowYear, int highYear) {
        int[] yearArray = new int[highYear - lowYear + 1];
        int maxAliveYear = lowYear;
        int maxAlive = 0;

        for (Person person : personList) {
            for (int year = person.birthYear; year <= person.deathYear; year++) {
                yearArray[year - lowYear]++;
            }
        }

        for (int year = 0; year < yearArray.length; year++) {
            if (yearArray[year] > maxAlive) {
                maxAlive = yearArray[year];
                maxAliveYear = year + lowYear;
            }
        }
        return maxAliveYear;
    }

    public static int maxAliveYear2(Person[] people, int min, int max) {
        int maxAlive = 0;
        int maxAliveYear = min;

        for (int year = min; year <= max; year++) {
            int alive = 0;
            for (Person person : people) {
                if (person.birthYear <= year && year <= person.deathYear) {
                    alive++;
                }
            }
            if (alive > maxAlive) {
                maxAlive = alive;
                maxAliveYear = year;
            }
        }

        return maxAliveYear;
    }
}
