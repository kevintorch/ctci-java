package hard.Q14_Smallest_K;

import others.AssortedMethods;

import static helpers.ArrayUtil.swap;

public class DIYSelectionAlgo {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
        int[] smallest = QuestionC.smallestK(array, 3);
        int[] smallest2 = smallestK(array, 3);
        System.out.println(AssortedMethods.arrayToString(smallest));
        System.out.println(AssortedMethods.arrayToString(smallest2));
//        System.out.println("Index: " + pivotIndex(0, array.length - 1));
    }

    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        int threshold = minAt(array, k - 1);
        int[] smallest = new int[k];
        int count = 0;
        for (int a : array) {
            if (a <= threshold) {
                smallest[count] = a;
                count++;
            }
        }
        return smallest;
    }

    private static int minAt(int[] array, int k) {
        return minAt(array, 0, array.length - 1, k);
    }

    private static int pivotIndex(int low, int high) {
        return (high - low) / 2;
    }

    private static int minAt(int[] array, int left, int right, int k) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];
        int leftEnd = partition(array, left, right, pivot);
        int leftSize = leftEnd - left + 1;
        if (k == leftSize - 1) {
            return max(array, left, leftEnd);
        } else if (k < leftSize) {
            return minAt(array, left, leftEnd, k);
        } else {
            return minAt(array, leftEnd + 1, right, k - leftSize);
        }
    }

    private static int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {
                swap(array, left, right);
                right--;
            } else if (array[right] <= pivot) {
                swap(array, left, right);
                left++;
            } else {
                left++;
                right--;
            }
        }
        return left - 1;
    }
}
