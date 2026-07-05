class Solution {
    int m = 1000000000+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high+1];
        Arrays.fill(dp,-1);
        return count(0,dp,low,high,zero,one);
        
    }
    public int count(int len, int dp[],int low, int high, int zero, int one){
        if(len>high) return 0;
       if(dp[len]!=-1) return dp[len];
       int ans = (len>=low)?1:0;
       ans = ans+count(len+zero,dp,low,high,zero,one);
       ans = ans+count(len+one,dp,low,high,zero,one);
       return dp[len]=  ans%m;
    }
}