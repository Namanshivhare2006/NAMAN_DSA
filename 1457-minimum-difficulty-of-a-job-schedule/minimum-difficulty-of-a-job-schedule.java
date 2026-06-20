// class Solution {
//     public int minDifficulty(int[] jD, int d) {
//         int n = jD.length;
//         if(n<d){
//             return -1;
//         }
//         return solve(jD,n,0,d);
//     }
//     public int solve(int []jD, int n, int idx, int d){
//         if(d==1){
//             int maxD = 0;
//             for(int i = idx; i<n; i++){
//                 maxD = Math.max(maxD,jD[i]);
//             }
//             return maxD;
//         }

//         int maxD = jD[idx];
//         int finalR = Integer.MAX_VALUE;

//         for(int i = idx; i<=n-d; i++){
//                         maxD = Math.max(maxD,jD[i]);
//                         int result = maxD + solve(jD,n,i+1,d-1);
//                         finalR = Math.min(finalR,result);
//         }
//         return finalR;

//     }
// }
class Solution {
    int dp[][];
    public int minDifficulty(int[] jD, int d) {
        
        int n = jD.length;
          dp = new int[n][d + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        if(n<d){
            return -1;
        }
        return solve(jD,n,0,d);
    }
    public int solve(int []jD, int n, int idx, int d){
         if (dp[idx][d] != -1) return dp[idx][d];

        if(d==1){
            int maxD = 0;
            for(int i = idx; i<n; i++){
                maxD = Math.max(maxD,jD[i]);
            }
              return dp[idx][d] = maxD;
        }

        int maxD = jD[idx];
        int finalR = Integer.MAX_VALUE;

        for(int i = idx; i<=n-d; i++){
                        maxD = Math.max(maxD,jD[i]);
                        int result = maxD + solve(jD,n,i+1,d-1);
                        finalR = Math.min(finalR,result);
        }
         return dp[idx][d] = finalR;

    }
}