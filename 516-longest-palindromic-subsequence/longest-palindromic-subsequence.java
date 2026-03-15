// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         int dp
//         return LPS(0,n-1,s);
        
//     }
//     static int LPS(int i, int j, String s){
//         if(i>j) return 0;
//         if(i==j) return 1;
//         if(s.charAt(i)==s.charAt(j)) return 2 + LPS(i+1,j-1,s);
//         else return Math.max(LPS(i+1, j, s),LPS(i, j-1,s));
//     }
// }
import java.util.Arrays;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return LPS(0, n - 1, s, dp);
    }

    static int LPS(int i, int j, String s, int dp[][]){
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == s.charAt(j))
            return dp[i][j] = 2 + LPS(i + 1, j - 1, s, dp);
        else
            return dp[i][j] = Math.max(
                LPS(i + 1, j, s, dp),
                LPS(i, j - 1, s, dp)
            );
    }
}