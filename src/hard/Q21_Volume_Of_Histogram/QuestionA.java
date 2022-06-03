package hard.Q21_Volume_Of_Histogram;

public class QuestionA {
    public static void main(String[] args) {
//        int[] histogramData = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        int[] histogramData = {0, 0, 4, 0, 5, 6, 0, 6, 3, 0};
        int vol = computeVolume(histogramData);
        System.out.println("Volume: " + vol);
    }


    public static int computeVolume(int[] histogramData) {
        int max = max(histogramData);
        if (max == 0) return 0;

        int leftHigh = histogramData[0];
        int rightHigh = histogramData[histogramData.length - 1];

        int leftIndex = 0;
        int rightIndex = histogramData.length - 1;
        int volume = 0;

        while (leftIndex < rightIndex) {
            int right = histogramData[rightIndex];
            int left = histogramData[leftIndex];
            if (left < max) {
                if (left > leftHigh) {
                    leftHigh = left;
                } else {
                    volume += leftHigh - left;
                }
                leftIndex++;
            }
            if (right < max) {
                if (right > rightHigh) {
                    rightHigh = right;
                } else {
                    volume += rightHigh - right;
                }
                rightIndex--;
            }
        }

        return volume;
    }

    public static int max(int[] histogramData) {
        if (histogramData == null || histogramData.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < histogramData.length; i++) {
            max = Math.max(histogramData[i], max);
        }
        return max;
    }
}
