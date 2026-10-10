
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long ans = 0;

        for (int d : diff) {
            int reduced = Math.min(d, low);
            ans += (long) reduced * reduced;
            k -= Math.max(d - low, 0);
        }

        // Use remaining operations to reduce some
        // differences equal to low by one.
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] >= low && diff[i] > 0) {
                ans -= (long) low * low
                     - (long) (low - 1) * (low - 1);
                k--;
            }
        }

        return ans;
    }
}
