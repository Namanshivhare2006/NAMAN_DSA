// class Solution {
//     public int minInsertions(String s) {
//         int n = s.length();
//         return solve(s,0,n-1);
        
//     }
//     public int solve(String s, int i, int j){
//         if(i>=j) return 0;
//         if(s.charAt(i)==s.charAt(j)) return solve(s,i+1,j-1);
//         return 1 + Math.min(solve(s,i+1,j), solve(s,i,j-1));
//     }
// }
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[501][501];
        for(int i = 0; i<501; i++){
            for(int j = 0; j<501; j++){
                dp[i][j] = -1;
            }
        }
        return solve(s,0,n-1,dp);
        
    }
    public int solve(String s, int i, int j, int dp[][]){
        if(i>=j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return solve(s,i+1,j-1,dp);
        return dp[i][j] = 1 + Math.min(solve(s,i+1,j,dp), solve(s,i,j-1,dp));
    }
}