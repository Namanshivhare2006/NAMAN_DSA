class Solution {
    int dp[] = new int[365];  //for days because days varry 
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,-1);
        int n = days.length;
        return solve(days,costs,n,0);
        
    }
    public int solve(int[] days, int[] costs,int n ,int i){
        if(i>=n) return 0;
      if(dp[i]!=-1) return dp[i];
        //1days
        int cost1 = costs[0] + solve(days,costs, n, i+1);
        //7days
        int j = i;
        int maxdays = days[i] + 7;
        while(j<n && days[j]<maxdays){
            j++;
        }
        int cost7 = costs[1] + solve(days,costs, n, j);

        //30days
        j = i;
         maxdays = days[i] + 30;
        while(j<n && days[j]<maxdays){
            j++;
        }
        int cost30 = costs[2] + solve(days,costs, n, j);

        return dp[i] = Math.min(cost1,Math.min(cost7,cost30));
    }
}