package moderate.living_people;


//  Given a list of people with their birth and death years, implement a method to compute the year
//  with the most number of people alive. You may assume that all people were born between 1900 and 2000 (inclusive).
//  If a person was alive during any portion of that year, they should be included in that year's count.
//  For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.

import java.util.List;

public class Question {
    public static void main(String[] args) {

    }

    public static int getAverageYear(List<Person> personList, int lowYear, int highYear) {
        int[] yearArray = new int[highYear - lowYear + 1];

        for (Person person : personList) {
            for (int year = person.birthYear; year <= person.deathYear; year++) {
                yearArray[year - lowYear]++;
            }
        }
        int maxYear = lowYear;
        for (int year : yearArray) {
            if (year > maxYear) {
                maxYear = year;
            }
        }
        return maxYear;
    }
}
