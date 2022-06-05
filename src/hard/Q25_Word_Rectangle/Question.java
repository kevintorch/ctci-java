package hard.Q25_Word_Rectangle;

import others.AssortedMethods;

public class Question {

    public static void main(String[] args) {
        WordRectangleBuilder builder = new WordRectangleBuilder(AssortedMethods.getListOfWords());
        Rectangle rect = builder.maxRectangle();
        if (rect != null) {
            rect.print();
        } else {
            System.out.println("No rectangle exists");
        }
    }

}
