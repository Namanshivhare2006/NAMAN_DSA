import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // Store all numbers in a HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        // Sum of the longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Check if the prefix is still sequential
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find the smallest missing integer
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}