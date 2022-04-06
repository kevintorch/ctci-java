package moderate.english_int;

import java.util.LinkedList;


// Given any integer, print an English phrase that describes the integer
// (e.g., "One Thousand, Two Hundred Thirty Four").

public class Question {
    static final String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    static final String[] biggies = {"", "Thousand", "Million", "Billion", "Trillion"};

    static final String hundred = "Hundred";

    static final String negative = "Negative";

    public static void main(String[] args) {
        int n = 12442433;

        /* numbers between 100000 and 1000000 */
        System.out.println(n + ": " + convert(n));
    }


    public static String convert(int num) {
        if (num == 0) {
            return smalls[0];
        } else if (num < 0) {
            return negative + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + biggies[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000; // shift chunk
            chunkCount++;
        }

        return listToString(parts);
    }

    /* Convert a linked list of strings to a string, dividing it up with spaces. */
    public static String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    public static String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();

        /* Convert hundreds place */
        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        /* Convert tens place */
        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        /* Convert one's place */
        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }


}
