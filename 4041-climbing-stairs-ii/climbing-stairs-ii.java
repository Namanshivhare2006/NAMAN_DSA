class Solution {
    int[] dp;

    private int solve(int i, int[] cost) {
        if (i > cost.length)
            return (int) 1e9;

        if (i == cost.length)
            return cost[i - 1];

        if (dp[i] != -1)
            return dp[i];

        int ans = (i - 1 >= 0) ? cost[i - 1] : 0;

        int x = 1 + solve(i + 1, cost);
        int y = 4 + solve(i + 2, cost);
        int z = 9 + solve(i + 3, cost);

        return dp[i] = ans + Math.min(x, Math.min(y, z));
    }

    public int climbStairs(int n, int[] cost) {
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, cost);
    }
}