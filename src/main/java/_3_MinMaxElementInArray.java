import java.util.List;

public class _3_MinMaxElementInArray {

    public static int[] minMaxElementInArray(List<Integer> nums) {

        if (nums == null || nums.isEmpty()) {
            return new int[] {};
        }

        int min = nums.get(0);
        int max = nums.get(0);

        int idx = 1;

        while (idx < nums.size()) {
            int curr = nums.get(idx);

            if (curr < min) {
                min = curr;
            }

            if (curr > max) {
                max = curr;
            }

            idx++;
        }

        return new int[] { min, max };
    }

    public static void main(String[] args) {

        int[] result1 = minMaxElementInArray(List.of(1, 4, 6, 2, 9));
        System.out.println("Min: " + result1[0] + ", Max: " + result1[1]);

        int[] result2 = minMaxElementInArray(List.of(-5, -1, -10, 0));
        System.out.println("Min: " + result2[0] + ", Max: " + result2[1]);

        int[] result3 = minMaxElementInArray(List.of());
        System.out.println("Result length: " + result3.length);
    }
}

