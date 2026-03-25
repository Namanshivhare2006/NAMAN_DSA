// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         if (n == 1) {
//             return nums[0];
//         }

//         int[] dp = new int[n];

//         dp[0] = nums[0];
//         dp[1] = Math.max(nums[0], nums[1]);

//         for (int i = 2; i < n; i++) {
//             dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//         }

//         return dp[n - 1];        
//     }
// }
// class Solution {
//     public int rob(int[] nums) {
//         return solve(0, nums);
//     }

//     private int solve(int i, int[] nums) {
//         if (i >= nums.length) return 0;

//         // choice 1 → rob
//         int rob = nums[i] + solve(i + 2, nums);

//         // choice 2 → skip
//         int skip = solve(i + 1, nums);

//         return Math.max(rob, skip);
//     }
// }
class Solution {
    public int rob(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for(int num:nums){
            int curr = Math.max(p1, p2+num);
            p2 = p1;
            p1 = curr;
        }  
        return p1;    
    }
}