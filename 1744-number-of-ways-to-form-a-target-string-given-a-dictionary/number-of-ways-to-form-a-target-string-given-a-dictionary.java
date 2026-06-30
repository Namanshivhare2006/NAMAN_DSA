// class Solution {

//     int MOD = 1_000_000_007;

//     public int numWays(String[] words, String target) {

//         int m = target.length();
//         int k = words[0].length();

//         // fre[character][column]
//         int[][] fre = new int[26][k];

//         for (int col = 0; col < k; col++) {
//             for (String word : words) {
//                 fre[word.charAt(col) - 'a'][col]++;
//             }
//         }

//         return (int) solve(0, 0, fre, target, m, k);
//     }

//     public long solve(int i, int j, int[][] fre, String target, int m, int k) {

//         // Target formed
//         if (i == m)
//             return 1;

//         // No columns left
//         if (j == k)
//             return 0;

//         // Skip current column
//         long notTake = solve(i, j + 1, fre, target, m, k);

//         // Take current column
//         long take = 0;
//         int count = fre[target.charAt(i) - 'a'][j];

//         if (count > 0) {
//             take = (count * solve(i + 1, j + 1, fre, target, m, k)) % MOD;
//         }

//         return (take + notTake) % MOD;
//     }
// }
class Solution {

    int MOD = 1_000_000_007;
    Long[][] dp;

    public int numWays(String[] words, String target) {

        int m = target.length();
        int k = words[0].length();

        // Frequency array: fre[character][column]
        int[][] fre = new int[26][k];

        for (int col = 0; col < k; col++) {
            for (String word : words) {
                char ch = word.charAt(col);
                fre[ch - 'a'][col]++;
            }
        }

        dp = new Long[m][k];

        return (int) solve(0, 0, fre, target, m, k);
    }

    public long solve(int i, int j, int[][] fre, String target, int m, int k) {

        if (i == m)
            return 1;

        if (j == k)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        // Skip current column
        long notTake = solve(i, j + 1, fre, target, m, k) % MOD;

        // Take current column
        long take = 0;
        int count = fre[target.charAt(i) - 'a'][j];

        if (count > 0) {
            take = (count * solve(i + 1, j + 1, fre, target, m, k)) % MOD;
        }

        return dp[i][j] = (take + notTake) % MOD;
    }
}