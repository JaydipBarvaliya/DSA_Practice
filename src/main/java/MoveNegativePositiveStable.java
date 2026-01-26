import java.util.ArrayList;
import java.util.List;

public class MoveNegativePositiveStable {

    public static List<Integer> moveNegativesFirst(List<Integer> nums) {

        if (nums == null || nums.isEmpty()) {
            return nums;
        }

        List<Integer> result = new ArrayList<>();

        // first pass: negatives
        for (int curr : nums) {
            if (curr < 0) {
                result.add(curr);
            }
        }

        // second pass: positives
        for (int curr : nums) {
            if (curr > 0) {
                result.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> output = moveNegativesFirst(List.of(0, 11, 2, 101, -9, 11, -2, -1, -9, -11, 1, 3, 7, 5));

        System.out.println(output);
    }
}
