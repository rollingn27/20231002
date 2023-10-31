import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArraySample {

    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
    }


    public static int maxProfit(int[] prices) {
        int maxP = 0;
        int minPrice = prices[0];

        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxP = Math.max(maxP, price - minPrice);
        }

        return maxP;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }

    public static int arrayPairSum(int[] nums) {

        int sum = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }

        return sum;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {

                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right -1])
                        right -= 1;

                    left += 1;
                    right -= 1;
                }

            }

        }

        return results;

    }
}
