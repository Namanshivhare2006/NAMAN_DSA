class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        long ans = 0;

        int bad = -1;
        int lastMin = -1;
        int lastMax = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < minK || nums[i] > maxK) {
                bad = i;
            }

            if (nums[i] == minK) {
                lastMin = i;
            }

            if (nums[i] == maxK) {
                lastMax = i;
            }

            ans += Math.max(0, Math.min(lastMin, lastMax) - bad);
        }

        return ans;
    }
}