class Solution {
    void flipcol(int [][]grid, int colum){
        for(int i = 0; i<grid.length; i++){
            grid[i][colum]^=1;
        }
    }
     int ans(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int totalSum = 0;

        for (int i = 0; i < rows; i++) {
            int x = 1;
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                    totalSum += x;
                x *= 2;
            }
        }
        return totalSum;
    }
    public int matrixScore(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i<row; i++){
            if(grid[i][0]==0){
                for(int j = 0; j<col; j++){
                    grid[i][j]^=1;                 //flip every col which start with 0
                }
            }
        }
        for(int i = 0; i<col; i++){
            int c0 = 0;
            int c1 = 0;
            for(int j = 0; j < row; j++){
                if(grid[j][i] == 0) c0++;   // FIXED
                else c1++;
            }

            if(c0>c1){
                flipcol(grid,i);
            }
        }
        return ans(grid);
    }
}