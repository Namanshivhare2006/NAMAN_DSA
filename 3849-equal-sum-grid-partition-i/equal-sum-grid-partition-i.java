class Solution {
    static long rowsum[];
    static long colsum[];
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        rowsum = new long[m];
        colsum = new long[n];
        long gridsum = calculatesum(grid);

        //check in row
        long currsum = rowsum[0];
        for(int i = 1; i<m; i++){
            
            if(currsum==gridsum-currsum) return true;
             currsum+=rowsum[i];
           
        }
        //check for col
        long csum = colsum[0];
        for(int i = 1; i<n; i++){
           
            if(csum==gridsum-csum) return true;
             csum+=colsum[i];
            
        }
        return false;
        
    }
    static long calculatesum(int [][] grid){
        long sum = 0;
        for(int i = 0; i<grid.length; i++){
            long rows = 0;
            for(int j = 0; j<grid[0].length; j++){
                sum+=grid[i][j];
                rows+=grid[i][j];
            }
            rowsum[i] = rows;
        }

        //for col sum
        for(int j = 0; j<grid[0].length; j++){
            long cols = 0;
            for(int i = 0; i<grid.length; i++){
                cols+=grid[i][j];
            }
            colsum[j]= cols;
        
    }
    return sum;
    }
}
    
