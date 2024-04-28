package arrays_strings;

// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2blc5a3.
// If the "compressed" string would not become smaller than the original string,
// your method should return the original string.
// You can assume the string has only uppercase and lowercase letters (a - z).

public class Q6_StringCompression {
    public static void main(String[] args) {
        String testString = "AaBbCc";
        System.out.println("Compress " + testString + ": " + compress(testString));
    }

    // My Way
    public static String compress(String str) {
        // string charset length is 26 * 2.
        // should return original string if not compressed.
        // sample str = "aabcccccaaa".
        if (str.length() <= 1) return str;
        int characterCounter = 0;
        char characterHolder = 0;
        boolean canCompressed = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (char chr : str.toCharArray()) {
            if (characterHolder != chr) {
                if (characterCounter > 0)
                    stringBuilder.append(characterHolder).append(characterCounter);
                characterHolder = chr;
                characterCounter = 1;
            } else {
                characterCounter++;
            }
            if (!canCompressed)
                canCompressed = characterCounter > 1;
        }
        if (characterCounter > 0) {
            stringBuilder.append(characterHolder).append(characterCounter);
        }

        return canCompressed ? stringBuilder.toString() : str;
    }

    // Alternative.
    public static String compress2(String str) {
        StringBuilder compressed = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            counter++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i)).append(counter);
                counter = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // Alternative But Optimal. BUT Duplicate Code, Two times iteration
    public static String compress3(String str) {
        int compressedLength = compressedLength(str);
        if (compressedLength >= str.length()) return str;

        StringBuilder stringBuilder = new StringBuilder(compressedLength); // knew length ahead of time (Optimal).
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            counter++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                stringBuilder.append(str.charAt(i)).append(counter);
                counter = 0;
            }
        }

        return stringBuilder.toString();
    }

    public static int compressedLength(String str) {
        int compressedLength = 0;
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            counter++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += String.valueOf(counter).length() + 1;
                counter = 0;
            }
        }
        return compressedLength;
    }
}
