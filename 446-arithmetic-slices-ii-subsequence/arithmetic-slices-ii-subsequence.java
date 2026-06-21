import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                long diff = (long) nums[i] - nums[j];

                int countAtJ = dp[j].getOrDefault(diff, 0);

                // Pair (nums[j], nums[i]) itself contributes 1
                dp[i].put(diff,
                          dp[i].getOrDefault(diff, 0) + countAtJ + 1);

                // Only sequences of length >= 3 are counted
                result += countAtJ;
            }
        }

        return result;
    }
}