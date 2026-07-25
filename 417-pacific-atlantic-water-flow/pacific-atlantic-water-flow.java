class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rowLength = heights.length;
        int colLength = heights[0].length;

        boolean[][] pacificVisited = new boolean[rowLength][colLength];
        boolean[][] atlanticVisited = new boolean[rowLength][colLength];
        
        for (int row = 0; row < rowLength; row++) {
            dfs(heights, pacificVisited, row, 0, 0);
        }

        for (int col = 0; col < colLength; col++) {
            dfs(heights, pacificVisited, 0, col, 0);
        }

        for (int row = 0; row < rowLength; row++) {
            dfs(heights, atlanticVisited, row, colLength - 1, 0);
        }

        for (int col = 0; col < colLength; col++) {
            dfs(heights, atlanticVisited, rowLength - 1, col, 0);
        }

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (pacificVisited[row][col] && atlanticVisited[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
            return;
        }
        
        if (visited[row][col]) {
            return;
        }

        if (heights[row][col] < prevHeight) {
            return;
        }

        int currHeight = heights[row][col];
        visited[row][col] = true;

        dfs(heights, visited, row + 1, col, currHeight);
        dfs(heights, visited, row - 1, col, currHeight);
        dfs(heights, visited, row, col + 1, currHeight);
        dfs(heights, visited, row, col - 1, currHeight);
    }
}