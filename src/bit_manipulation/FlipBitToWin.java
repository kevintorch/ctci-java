package bit_manipulation;

// You have an integer, and you can flip exactly one bit from a O to a 1.
// Write code to find the length of the longest sequence of 1 s you could create.
//
// EXAMPLE
// Input: 1775 (or: 11011101111) Output: 8

import java.util.ArrayList;

public class FlipBitToWin {
    public static void main(String[] args) {
        int[][] cases = {{-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1},
                {1, 2}, {15, 5}, {1775, 8}};
        for (int[] c : cases) {
            int x = flipBit(c[0]);
            boolean r = (c[1] == x);
            System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
        }

    }


    public static int flipBit(int num) {
        final String binaryString = Integer.toBinaryString(num);

        int zeroBitPos = -1;
        int highNumber = 0;
        int highNumberZeroBitPos = -1;
        int oneCounter = 0;
        boolean encounterZeroBefore = false;
        for (char ch : binaryString.toCharArray()) {
            if (ch == '1') {
                oneCounter++;
            } else if (ch == '0') {
                if (!encounterZeroBefore) {
                    encounterZeroBefore = true;
                    zeroBitPos = binaryString.indexOf(ch);
                } else {
                    encounterZeroBefore = false;
                    if (oneCounter > highNumber) {
                        highNumber = oneCounter;
                        if (zeroBitPos != -1)
                            highNumberZeroBitPos = zeroBitPos;
                    }
                    zeroBitPos = -1;
                    oneCounter = 0;
                }
            }
        }

        if (oneCounter > highNumber) {
            highNumber = oneCounter;
            if (zeroBitPos != -1)
                highNumberZeroBitPos = zeroBitPos;
        }

        num |= 1 << highNumberZeroBitPos;
        return highNumber;
    }


    public static int longestSequence(int num) {
        if (num == -1) return Integer.SIZE;

        ArrayList<Integer> sequences = getAlternatingSequences(num);
        return findLongestSequence(sequences);
    }

    private static ArrayList<Integer> getAlternatingSequences(int num) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i < Integer.SIZE; i++) {
            if ((num & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = num & 1;
                counter = 0;
            }
            counter++;
            num >>>= 1;
        }
        sequences.add(counter);

        return sequences;
    }

    private static int findLongestSequence(ArrayList<Integer> sequences) {
        int maxSeq = 1;
        for (int i = 0; i < sequences.size(); i += 2) {
            int zeroSeq = sequences.get(i);
            int oneSeqRight = i - 1 >= 0 ? sequences.get(i - 1) : 0;
            int oneSeqLeft = i + 1 < sequences.size() ? sequences.get(i + 1) : 0;

            int thisSeq = 0;
            if (zeroSeq == 1) {
                thisSeq = oneSeqLeft + 1 + oneSeqRight;
            } else if (zeroSeq > 1) {
                thisSeq = 1 + Math.max(oneSeqRight, oneSeqLeft);
            } else if (zeroSeq == 0) {
                thisSeq = Math.max(oneSeqRight, oneSeqLeft);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }
        return maxSeq;
    }
}
