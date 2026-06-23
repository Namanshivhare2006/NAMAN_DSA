class Solution {
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {

        int k = r - l + 1;

        if (n == 1) return k;

        long[][] dp = new long[k][2];

        // length = 2
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < k; b++) {

                if (a == b) continue;

                if (a < b)
                    dp[b][1]++;
                else
                    dp[b][0]++;
            }
        }

        for (int len = 3; len <= n; len++) {

            long[] pref0 = new long[k];
            long[] pref1 = new long[k];

            pref0[0] = dp[0][0];
            pref1[0] = dp[0][1];

            for (int i = 1; i < k; i++) {
                pref0[i] = (pref0[i - 1] + dp[i][0]) % MOD;
                pref1[i] = (pref1[i - 1] + dp[i][1]) % MOD;
            }

            long[][] ndp = new long[k][2];

            for (int x = 0; x < k; x++) {

                // increasing
                if (x > 0)
                    ndp[x][1] = pref0[x - 1];

                // decreasing
                long total = pref1[k - 1];
                long left = pref1[x];

                ndp[x][0] = (total - left + MOD) % MOD;
            }

            dp = ndp;
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            ans = (ans + dp[i][0] + dp[i][1]) % MOD;
        }

        return (int) ans;
    }
}