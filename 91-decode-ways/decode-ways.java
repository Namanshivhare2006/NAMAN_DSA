class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i= 2; i<=n; i++){
            int oned = Integer.valueOf(s.substring(i-1,i));
            int secondd = Integer.valueOf(s.substring(i-2,i));
            if(oned>=1){
                dp[i]+=dp[i-1];

            }
            if(secondd<=26 && secondd>=10){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
        
    }
}