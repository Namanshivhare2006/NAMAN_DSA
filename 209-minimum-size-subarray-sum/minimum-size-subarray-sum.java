class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = 0; j<n; j++){
            sum+=nums[j];
            while(sum>=target){
                ans = Math.min(ans,j-i+1);
                sum-=nums[i];
                i++;
            }
            
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}