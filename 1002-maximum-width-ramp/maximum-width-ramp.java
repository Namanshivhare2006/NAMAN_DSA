class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int []leftmin = new int[n];
        int []rightmax = new int[n];

        leftmin[0] = nums[0];
        for(int i = 1; i<n; i++){
            leftmin[i] = Math.min(leftmin[i-1],nums[i]);
        }
        rightmax[n-1] = nums[n-1];
        for(int i = n-2; i>=0; i--){
            rightmax[i] = Math.max(rightmax[i+1], nums[i]);
        }
        int i = 0; int j = 0;
        int ans = 0;
        while(i<n && j<n){
            if(leftmin[i]<=rightmax[j]){
                ans = Math.max(ans,j-i);
                j++;
            }else{
                i++;
            }
        }
        return ans;
        
    }
}