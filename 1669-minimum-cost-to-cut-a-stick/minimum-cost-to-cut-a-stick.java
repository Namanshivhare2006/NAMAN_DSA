import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        
        int[] dp = new int[m + 2];
        
        dp[0] = 0;
        dp[m + 1] = n;
        
        for (int i = 0; i < m; i++) {
            dp[i + 1] = cuts[i];
        }
        
        Arrays.sort(dp);
        
        int[][] memo = new int[m + 2][m + 2];
        
        return cost(1, m, dp, memo);
    }

    static int cost(int i, int j, int[] dp, int[][] memo) {
        if (i > j) return 0;

        if (memo[i][j] != 0) return memo[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int len = dp[j + 1] - dp[i - 1];

            int total = len 
                      + cost(i, k - 1, dp, memo)
                      + cost(k + 1, j, dp, memo);

            min = Math.min(min, total);
        }

        return memo[i][j] = min;
    }
}