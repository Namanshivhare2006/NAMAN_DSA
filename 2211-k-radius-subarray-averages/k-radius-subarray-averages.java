class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;

        if (k == 0) {
            return nums;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (n < 2 * k + 1) {
            return ans;
        }

        long window = 0;
        int left = 0;
        int right = 2 * k;
        int idx = k;

        // First window sum
        for (int i = left; i <= right; i++) {
            window += nums[i];
        }

        int count = 2 * k + 1;
        ans[idx] = (int) (window / count);

        idx++;

        // Slide the window
        while (right < n - 1) {
            window -= nums[left];
            left++;

            right++;
            window += nums[right];

            ans[idx] = (int) (window / count);
            idx++;
        }

        return ans;
    }
}