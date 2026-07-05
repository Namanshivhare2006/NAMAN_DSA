// class Solution {
//     int m = 1000000000+7;
//     public int numberOfArrays(String s, int k) {
//         int n = s.length();
//         return solve(0,s,k);
        
//     }
//     public int solve(int start , String s, int k){
//         if(start>=s.length()) return 1;
//         if(s.charAt(start)=='0') return 0;
//         long ans = 0;
//         long num = 0;
//         for(int end = start; end<s.length(); end++){
//             num = num*10 + (s.charAt(end) - '0');
//             if(num>k) break;

//             ans = (ans + solve(end+1, s, k))%m;
//         }
//         return (int)ans;
//     }
// }

class Solution {
    int m = 1000000000+7;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,k,dp);
        
    }
    public int solve(int start , String s, int k,  int dp[]){
        if(start>=s.length()) return 1;
        if(s.charAt(start)=='0') return dp[start] = 0;
        if(dp[start]!=-1) return dp[start];
        long ans = 0;
        long num = 0;
        for(int end = start; end<s.length(); end++){
            num = num*10 + (s.charAt(end) - '0');
            if(num>k) break;

            ans = (ans + solve(end+1, s, k,dp))%m;
        }
        return dp[start] = (int)ans;
    }
}