package helpers;

public class StringUtil {
    public static String space(int size) {
        return String.join("", new Spacer(size));
    }
}
