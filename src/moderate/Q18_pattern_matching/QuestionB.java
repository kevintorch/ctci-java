package moderate.Q18_pattern_matching;

public class QuestionB {
    public static void main(String[] args) {

    }

    private static boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);
        int size = value.length();
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize < maxMainSize; mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            String first = value.substring(0, mainSize);
            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;
                String second = countOfAlt == 0 ? "" : value.substring(altIndex, altSize + altIndex);
                String cand = buildFromPattern(pattern, first, second);
                if (cand.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int countOf(String pattern, char c) {
        int count = 0;
        for (char ch : pattern.toCharArray()) {
            if (c == ch) count++;
        }
        return count;
    }

    private static String buildFromPattern(String pattern, String main, String alt) {
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }
        return sb.toString();
    }

}
