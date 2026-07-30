class Solution {
    public int numSubseq(int[] nums, int target) {

        int n = nums.length;
        int MOD = 1000000007;

        Arrays.sort(nums);

        // Precompute powers of 2
        int[] pow = new int[n];
        pow[0] = 1;
        for(int i = 1; i < n; i++){
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int l = 0;
        int r = n - 1;
        int res = 0;

        while(l <= r){
            if(nums[l] + nums[r] <= target){
                res = (res + pow[r - l]) % MOD;
                l++;
            }else{
                r--;
            }
        }

        return res;
    }
}