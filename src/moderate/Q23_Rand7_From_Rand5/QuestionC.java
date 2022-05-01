package moderate.Q23_Rand7_From_Rand5;

public class QuestionC {
    public static void main(String[] args) {
        /* Test: call rand7 many times and inspect the results. */
        int[] arr = new int[7];
        int test_size = 1000000;
        for (int k = 0; k < test_size; k++) {
            arr[rand7()]++;
        }

        for (int i = 0; i < 7; i++) {
            double percent = 100.0 * arr[i] / test_size;
            System.out.println(i + " appeared " + percent + "% of the time.");
        }
    }

    public static int rand7() {
        while (true) {
            int r1 = 3 * rand5();
            int r2 = rand5();
            if (r2 < 3) {
                int r = r1 + r2;
                if (r < 14) {
                    return r % 7;
                }
            }
        }

    }

    public static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }
}
