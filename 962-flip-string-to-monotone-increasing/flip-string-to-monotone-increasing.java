// class Solution {
//     public int minFlipsMonoIncr(String s) {
//         int n = s.length();
//         int dp[][] = new int[n][2];
//         for(int i = 0; i<n; i++){
//             for(int j = 0; j<2; j++){
//                 dp[i][j] = -1;
//             }
//         }
//         return solve(s,n,0,0,dp);
//     }
//     public int solve(String s,int n,int curr, int prev, int dp[][]){
//         if(curr>=n){
//             return 0;
//         }
//         if(dp[curr][prev]!=-1){
//             return dp[curr][prev];
//         }
//         int flip = Integer.MAX_VALUE;
//         int noflip = Integer.MAX_VALUE;

//         if(s.charAt(curr)=='0'){
//              if(prev==1){
//                 flip = 1+solve(s,n,curr+1,1,dp);
//              }else{
//                 flip = 1 + solve(s,n,curr+1,1,dp);
//                 noflip = solve(s,n,curr+1,0,dp);
//              }
//         }else if(s.charAt(curr)=='1'){
//               if(prev==1){
//                 noflip = solve(s,n,curr+1,1,dp);
//              }else{
//                 flip = 1 + solve(s,n,curr+1,0,dp);
//                 noflip = solve(s,n,curr+1,1,dp);
//              }
//         }
//         return dp[curr][prev] = Math.min(flip,noflip);

//         }
//     }
class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0;
        int count = 0;
        for(char x : s.toCharArray()){
            if(x=='1'){
                count++;
            }
            else if(count!=0){
                res++;
                count--;
            }
            
        }
        return res;
    }
}