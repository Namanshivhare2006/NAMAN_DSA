class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        long sum = 0;
        long ans = 0;

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            while (j - i + 1 > k) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}