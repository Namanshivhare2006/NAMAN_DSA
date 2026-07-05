// class Solution {
//     public int maxUncrossedLines(int[] nums1, int[] nums2) {
//         return solve(0,0,nums1,nums2);
        
//     }
//     public int solve(int i, int j, int []nums1, int nums2[]){
//         if(i>=nums1.length || j>=nums2.length) return 0;

//         if(nums1[i]==nums2[j]) return 1+ solve(i+1,j+1,nums1,nums2);

//         return Math.max(solve(i+1,j,nums1,nums2), solve(i,j+1,nums1,nums2));
//     }
// }
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][] = new int[500][500];
        for(int i = 0; i<500; i++){
            for(int j = 0; j<500; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0,nums1,nums2,dp);
        
    }
    public int solve(int i, int j, int []nums1, int nums2[],int dp[][]){
        if(i>=nums1.length || j>=nums2.length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if(nums1[i]==nums2[j]) return dp[i][j] = 1+ solve(i+1,j+1,nums1,nums2,dp);

        return dp[i][j] = Math.max(solve(i+1,j,nums1,nums2,dp), solve(i,j+1,nums1,nums2,dp));
    }
}