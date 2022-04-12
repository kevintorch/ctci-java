package moderate.xml_encoding;


import java.util.Collection;

public class Question {
    public static void main(String[] args) {
        Element root = new Element("family");
        Attribute a1 = new Attribute("lastName", "mcdowell");
        Attribute a2 = new Attribute("state", "CA");
        root.insert(a1);
        root.insert(a2);

        Element child = new Element("person", "Some Message");
        Attribute a3 = new Attribute("firstName", "Gayle");
        child.insert(a3);

        root.insert(child);

        String s = encodeToString(root);
        System.out.println(s);
    }

    public static String encodeToString(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    public static StringBuilder encode(Element root, StringBuilder sb) {
        sb.append(root.getTagCode()).append(" ");
        encodeAttrs(sb, root.attributes);
        sb.append(0).append(" ");
        if (root.value != null && !root.value.isEmpty()) {
            sb.append(root.value).append(" ");
        } else if (!root.children.isEmpty()) {
            for (Element child : root.children) {
                encode(child, sb);
            }
        }
        sb.append(0).append(" ");
        return sb;
    }

    private static void encodeAttrs(StringBuilder sb, Collection<Attribute> attributes) {
        for (Attribute attribute : attributes) {
            sb.append(attribute.getTagCode()).append(" ");
            sb.append(attribute.value).append(" ");
        }
    }
}
