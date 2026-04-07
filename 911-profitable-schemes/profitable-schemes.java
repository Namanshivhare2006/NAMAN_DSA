// class Solution {
//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//         return solve(0, 0, 0, n, minProfit, group, profit);
//     }

//     public int solve(int i, int members, int currProfit, int n, int minProfit, int[] group, int[] profit) {
        
//         // base case
//         if (i == group.length) {
//             return currProfit >= minProfit ? 1 : 0;
//         }
//         int skip = solve(i + 1, members, currProfit, n, minProfit, group, profit);

//         int take = 0;
//         if (members + group[i] <= n) {
//             take = solve(  i + 1, members + group[i],currProfit + profit[i],n,minProfit, group,  profit );
//         }

//         return skip + take;
//     }
// }

// class Solution {
//     int[][][] dp = new int[102][102][102];
//     int mod = 1000000000+7;

//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//         return solve(0, 0, 0, n, minProfit, group, profit)%mod;
//     }

//     public int solve(int i, int members, int currProfit, int n, int minProfit, int[] group, int[] profit) {

//         // base case
//         if (i == group.length) {
//             return currProfit >= minProfit ? 1 : 0;
//         }

//         // cap profit to avoid overflow of dimension
//         currProfit = Math.min(currProfit, minProfit);

//         if (dp[i][members][currProfit] != 0) {
//             return dp[i][members][currProfit];
//         }

//         int skip = solve(i + 1, members, currProfit, n, minProfit, group, profit);

//         int take = 0;
//         if (members + group[i] <= n) {
//             take = solve(
//                 i + 1,
//                 members + group[i],
//                 currProfit + profit[i],
//                 n,
//                 minProfit,
//                 group,
//                 profit
//             );
//         }

//         return dp[i][members][currProfit] = (skip + take ) % mod;
//     }
// }
class Solution {
    int[][][] dp = new int[102][102][102];
    int mod = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        for (int[][] arr2D : dp)
            for (int[] arr1D : arr2D)
                Arrays.fill(arr1D, -1);

        return solve(0, 0, 0, n, minProfit, group, profit);
    }

    public int solve(int i, int members, int currProfit, int n, int minProfit, int[] group, int[] profit) {

        currProfit = Math.min(currProfit, minProfit);

        if (i == group.length) {
            return currProfit >= minProfit ? 1 : 0;
        }

        if (dp[i][members][currProfit] != -1) {
            return dp[i][members][currProfit];
        }

        int skip = solve(i + 1, members, currProfit, n, minProfit, group, profit);

        int take = 0;
        if (members + group[i] <= n) {
            take = solve(
                i + 1,
                members + group[i],
                currProfit + profit[i],
                n,
                minProfit,
                group,
                profit
            );
        }

        return dp[i][members][currProfit] = (skip + take) % mod;
    }
}