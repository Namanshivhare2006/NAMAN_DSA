class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k;
        int j = k;
        int curmin = nums[k];
        int max = nums[k];
        int n = nums.length;
        while (i > 0 || j < n - 1) {
            int leftV = (i > 0) ? nums[i - 1] : 0;
            int rightV = (j < n - 1) ? nums[j + 1] : 0;
            if (leftV < rightV) {
                j++;
                curmin = Math.min(curmin, nums[j]);
            } else {
                i--;
                curmin = Math.min(curmin, nums[i]);
            }
            max = Math.max(max, curmin * (j - i + 1));
        }
        return max;
    }
}