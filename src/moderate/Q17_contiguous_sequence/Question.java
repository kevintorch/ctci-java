package moderate.Q17_contiguous_sequence;


//  You are given an array of integers (both positive and negative).
//  Find the contiguous sequence with the largest sum. Return the sum.
//
// EXAMPLE
// Input: 2, -8, 3, -2, 4, -10
// Output: 5 (i.e•, {3, -2, 4})

public class Question {
    public static void main(String[] args) {
        int[] array = {2, -8, 3, -2, 4, -10};
        int largestSum = findLargestSum(array);
        System.out.println("Largest Sum = " + largestSum);
    }

    public static int findLargestSum(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (maxSum < sum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

}
