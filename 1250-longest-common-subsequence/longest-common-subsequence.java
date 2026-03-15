// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int i = text1.length()-1;
//         int j = text2.length()-1;
//         return LCS(i,j,text1, text2);
//     }
//     static int LCS(int i, int j, String text1, String text2 ){
//         if(i<0 || j<0) return 0;
//         if(text1.charAt(i)==text2.charAt(j)) return 1 + LCS(i-1, j-1, text1, text2);
//         else return Math.max(LCS(i-1, j, text1, text2), LCS(i, j-1, text1, text2));
//     }
// }
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length() - 1;
        int j = text2.length() - 1;

        int dp[][] = new int[text1.length()][text2.length()];

        for(int m = 0; m < text1.length(); m++){
            for(int n = 0; n < text2.length(); n++){
                dp[m][n] = -1;
            }
        }

        return LCS(i, j, text1, text2, dp);
    }

    static int LCS(int i, int j, String text1, String text2, int dp[][]){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + LCS(i-1, j-1, text1, text2, dp);
        else
            return dp[i][j] = Math.max(
                LCS(i-1, j, text1, text2, dp),
                LCS(i, j-1, text1, text2, dp)
            );
    }
}