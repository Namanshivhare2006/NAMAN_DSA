class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int arr[] = new  int[n*m];
        int k = 0;
      for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            arr[k++] = grid[i][j];

        }
      }
        Arrays.sort(arr);
        int idx = n*m/2;
        int midelemnt = arr[idx];
      int oper = 0;
      for(int num : arr){
        int totald = Math.abs(num - midelemnt );
         if (totald % x != 0) return -1;

        oper+=totald/x;
      }
      return oper;
    }
}