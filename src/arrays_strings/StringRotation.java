package arrays_strings;

// Assume you have a method isSubString which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString
// (e.g., "waterbottle" is a rotation of "erbottlewat").

public class StringRotation {
    public static void main(String[] args) {
        String sampleString2 = "waterbottle";
        String sampleString1 = "erbottlewat";

        System.out.println("is Rotation: " + isRotation2("helloworld", "worldhelli"));
    }

    // Wrong Way.
    // My Way But in Hurry.
    public static boolean isRotation(String s2, String s1) {
        if (s1.length() != s2.length()) return false;

        StringBuilder stringBuilder = new StringBuilder();
        int offset = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i - offset)) {
                stringBuilder.append(s1.charAt(i));
            } else {
                offset++;
            }
        }
        return isSubString(s1, stringBuilder.toString());
    }

    // Right Way.
    // Complexity O(N) or O(A + B) if A and B are the length of Strings.
    public static boolean isRotation2(String s1, String s2) {

        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }

        return false;
    }

    private static boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }
}
