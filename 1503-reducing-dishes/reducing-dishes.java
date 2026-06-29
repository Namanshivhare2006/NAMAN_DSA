// class Solution {
//     public int maxSatisfaction(int[] sati) {
//         int n = sati.length;
//         Arrays.sort(sati);
//         return solve(sati,0,1);

        
//     }
//     public int solve(int[] sati,int i, int time){
//         if(i>=sati.length){
//             return 0;
//         }

//         int include = sati[i]*time + solve(sati,i+1,time+1);
//         // for exclude
//           int exclude =  solve(sati,i+1,time);
//           return Math.max(include,exclude);

//     }
// }

class Solution {

    public int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int n = satisfaction.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);

        return solve(satisfaction, 0, 1, dp);
    }

    int solve(int[] sat, int i, int time, int[][] dp) {

        if (i == sat.length)
            return 0;

        if (dp[i][time] != Integer.MIN_VALUE)
            return dp[i][time];

        int include = sat[i] * time + solve(sat, i + 1, time + 1, dp);

        int exclude = solve(sat, i + 1, time, dp);

        return dp[i][time] = Math.max(include, exclude);
    }
}