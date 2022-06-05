package hard.Q26_Sparse_Similarity;

public class Question {

//    public static void main(String[] args) {
//        int numDocuments = 10;
//        int docSize = 5;
//        HashMap<Integer, Document> documents = new HashMap<>();
//        ArrayList<Document> documentsArray = new ArrayList<>();
//        for (int i = 0; i < numDocuments; i++) {
//            int[] words = AssortedMethods.randomArray(docSize, 0, 10);
//            ArrayList<Integer> w = Tester.removeDups(words);
//            System.out.println(i + ": " + w);
//            Document doc = new Document(i, w);
//            documentsArray.add(doc);
//            documents.put(i, doc);
//        }
//
//        List<DocPair> similarities = computeSimilarities(documentsArray.toArray(new Document[0]));
//        printSim(similarities);
//
////        Tester.printSim(similarities);
//    }
//
//    private static void printSim(List<DocPair> similarities) {
//        for (DocPair pair : similarities) {
//            System.out.println(pair.id1 + ", " + pair.id2 + " : " + pair.similarity);
//        }
//    }
//
//
//    public static List<DocPair> computeSimilarities(Document[] documents) {
//        ArrayList<DocPair> similarities = new ArrayList<>();
//        for (int i = 0; i < documents.length; i++) {
//            for (int j = 0; j < documents.length; j++) {
//                Document document1 = documents[i];
//                Document document2 = documents[j];
//                Integer[][] pair = intersectionUnionPair(document1.words, document2.words);
//                if (pair[0].length > 0) {
//                    double similarity = ((double) pair[0].length) / ((double) pair[1].length);
//                    similarities.add(new DocPair(document1.id, document2.id, similarity));
//                }
//            }
//        }
//        return similarities;
//    }
//
//    private static Integer[][] intersectionUnionPair(Integer[] a, Integer[] b) {
//        ArrayList<Integer> intersection = new ArrayList<>();
//        ArrayList<Integer> union = new ArrayList<>();
//        Integer[] smaller = a.length > b.length ? b : a;
//        Integer[] bigger = smaller == a ? b : a;
//        Set<Integer> smallerSet = new HashSet<>(Arrays.asList(smaller));
//
//        for (int i = 0; i < bigger.length; i++) {
//            Integer value = bigger[i];
//            if (smallerSet.contains(value)) {
//                intersection.add(value);
//            } else {
//                union.add(value);
//            }
//        }
//
//        Integer[] intersectionArray = intersection.toArray(Integer[]::new);
//        Integer[] unionArray = union.toArray(Integer[]::new);
//        return new Integer[][]{intersectionArray, unionArray};
//    }
}


