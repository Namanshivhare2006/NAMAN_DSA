class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int []sufmin = new int[n];
        sufmin[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            sufmin[i] = Math.min(sufmin[i+1],nums[i]);
        }
        int prefixmax  = nums[0];
        for(int i = 0; i<n; i++){
            prefixmax = Math.max(prefixmax,nums[i]);
            if(prefixmax-sufmin[i]<=k){
                return i;
            }
        }
        return -1;
    }
}