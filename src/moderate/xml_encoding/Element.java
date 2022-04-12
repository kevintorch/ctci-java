package moderate.xml_encoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Element {
    String name;
    String value;
    List<Attribute> attributes = new ArrayList<>();
    List<Element> children = new ArrayList<>();


    public Element(String name) {
        this.name = name;
    }

    public Element(String name, String value) {
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

    public void addAttribute(String name, String value) {
        attributes.add(new Attribute(name, value));
    }

    public boolean hasAttribute(String name) {
        return attributes.stream().anyMatch(attribute -> Objects.equals(attribute.name, name));
    }

    public void insert(Element child) {
        children.add(child);
    }

    public void insert(Attribute attribute) {
        addAttribute(attribute.name, attribute.value);
    }
}
