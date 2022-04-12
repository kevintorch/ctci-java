package moderate.xml_encoding;

public class QuestionOO {
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

    private static void encode(Element root, StringBuilder sb) {
        encode(root.getTagCode(), sb);
        for (Attribute attribute : root.attributes) {
            encode(attribute, sb);
        }
        encode("0", sb);

        if (root.value != null && !root.value.isEmpty()) {
            encode(root.value, sb);
        } else if (!root.children.isEmpty()) {
            for (Element element : root.children) {
                encode(element, sb);
            }
        }
        encode("0", sb);
    }

    private static void encode(Attribute attribute, StringBuilder sb) {
        encode(attribute.getTagCode(), sb);
        encode(attribute.value, sb);
    }

    private static void encode(String value, StringBuilder sb) {
        sb.append(value);
        sb.append(" ");
    }
}
