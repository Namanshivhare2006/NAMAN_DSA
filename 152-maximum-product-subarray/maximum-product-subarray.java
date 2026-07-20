class Solution {
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(nums[i], nums[i] * maxEnding);
            minEnding = Math.min(nums[i], nums[i] * minEnding);

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}