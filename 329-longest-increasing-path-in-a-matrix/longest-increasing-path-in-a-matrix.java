class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int ans = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                 ans = Math.max(ans, solve(i,j,dp,matrix,n,m));
            }
        }
        return ans;
        
    }
    public static int solve(int i, int j, int dp[][], int matrix[][],int n, int m){

        if(dp[i][j] != 0) return dp[i][j];
       int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int max = 1;

        for(int k= 0; k<4;k++){
            int x = i + dr[k];
            int y = j + dc[k];
            if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]>matrix[i][j]){
                max = Math.max(max, 1+ solve(x,y,dp,matrix,n,m));
            }
        }
         dp[i][j] = max;
         return max;
    }
}

// n = martrix .length
// m = matrix[0].length;
// int [][] dp = new int[n][m];


// take function for finding path
// create dir array for moving
// and check boundary condition
// if
// inside the function
// pass i and j in function
// if(dp[i][j]!=0) return dp[i][j]   
// max = 0   //formaintain length
// for(int []d : direction)    //took form directiona rrayyfin
// find new cell
// x = i + d[0];
// y = j + d[1];

// and after we check boundary condition
// if(x>=0 && y>=0 && x<n && y<m && mat[x][y]>matrix[i][j] ) 
// and then find max
// max = max(max,1+function())

// in the end we return dp[i][j];


