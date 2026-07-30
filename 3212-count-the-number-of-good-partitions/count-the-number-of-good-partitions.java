class Solution {
    public int numberOfGoodPartitions(int[] nums) {

        int mod = 1000000007;
        int n = nums.length;

        HashMap<Integer, Integer> lastidx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            lastidx.put(nums[i], i);
        }

        int i = 0;
        int j = lastidx.get(nums[0]);
        int res = 1;

        while (i < n - 1) {

            j = Math.max(j, lastidx.get(nums[i]));

            if (i == j) {
                res = (res * 2) % mod;
            }

            i++;
        }

        return res;
    }
}