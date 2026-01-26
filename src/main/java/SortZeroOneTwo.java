import java.util.ArrayList;
import java.util.List;

public class SortZeroOneTwo {

    public static List<Integer> sortZeroOneTwo(List<Integer> nums) {

        if (nums == null || nums.isEmpty()) {
            return new ArrayList<>();
        }

        int numOfZero = 0;
        int numOfOne = 0;
        int numOfTwo = 0;

        for (int curr : nums) {
            if (curr == 0) numOfZero++;
            else if (curr == 1) numOfOne++;
            else if (curr == 2) numOfTwo++;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numOfZero; i++) {
            result.add(0);
        }

        for (int i = 0; i < numOfOne; i++) {
            result.add(1);
        }

        for (int i = 0; i < numOfTwo; i++) {
            result.add(2);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> output = sortZeroOneTwo(List.of(10,10,10, 0, 0, 2, 1, 0, 2, 2, 1));
        System.out.println(output);
    }
}
