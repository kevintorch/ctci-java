package moderate.xml_encoding;

import java.util.Objects;

public class Attribute {
    String name;
    String value;

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getTagCode() {
        if (Objects.equals(name, "family")) {
            return "1";
        } else if (Objects.equals(name, "person")) {
            return "2";
        } else if (Objects.equals(name, "firstName")) {
            return "3";
        } else if (Objects.equals(name, "lastName")) {
            return "4";
        } else if (Objects.equals(name, "state")) {
            return "5";
        }
        return "--";
    }
}
