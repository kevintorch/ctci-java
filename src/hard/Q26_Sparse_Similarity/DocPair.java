package hard.Q26_Sparse_Similarity;

public class DocPair {
    public int doc1, doc2;

    public DocPair(int doc1, int doc2) {
        this.doc1 = doc1;
        this.doc2 = doc2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocPair docPair)) return false;

        if (doc1 != docPair.doc1) return false;
        return doc2 == docPair.doc2;
    }

    @Override
    public int hashCode() {
        int result = doc1;
        result = 31 * result + doc2;
        return result;
    }
}
