package moderate;

public class TypingMistake {
    public static void main(String[] args) {
        String I = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc";
        String P = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etccc";
        int charCountToMakeSimilar = getCharCountToMakeSimilar(I, P);
        System.out.println("Case #: " + (charCountToMakeSimilar == -1 ? "IMPOSSIBLE" :
                String.valueOf(charCountToMakeSimilar)));

    }

    public static int getCharCountToMakeSimilar(String I, String P) {
        if (I.equals(P)) return 0;
        else if (I.length() == P.length()) return -1;
        else if (P.length() < I.length()) return -1;

        int iIndex = 0;
        int pIndex = 0;
        int diff = 0;
        while (pIndex < P.length()) {
            if (P.charAt(pIndex) == I.charAt(iIndex)) {
                iIndex++;
                pIndex++;
            } else if (P.charAt(pIndex) == P.charAt(pIndex - 1)) {
                pIndex++;
                diff++;
            } else {
                return -1;
            }
        }
        return diff;
    }
}
