class Solution {
    public int cost(int i, int j, int arr[],int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int totalcost = arr[i-1]*arr[k]*arr[j+1] + cost(i,k-1,arr,dp)+cost(k+1,j,arr,dp);
            res = Math.max(res,totalcost);
        }
        return dp[i][j] = res;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        int dp[][] = new int[n+1][n+1];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }        
        for(int i = 0; i<n; i++){
            arr[i+1] = nums[i];
        }
        return cost(1,n,arr,dp);
    }
}