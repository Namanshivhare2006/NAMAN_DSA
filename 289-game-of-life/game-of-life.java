class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int live = 0;

                // Check 8 neighbors
                for (int k = 0; k < 8; k++) {

                    int ni = i + dr[k];
                    int nj = j + dc[k];

                    if (ni >= 0 && ni < m &&
                        nj >= 0 && nj < n) {

                        // 1 and 2 mean originally alive
                        if (board[ni][nj] == 1 ||
                            board[ni][nj] == 2) {
                            live++;
                        }
                    }
                }

                // Live cell
                if (board[i][j] == 1) {

                    if (live < 2 || live > 3) {
                        board[i][j] = 2;
                    }
                }

                // Dead cell
                else if (board[i][j] == 0) {

                    if (live == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        // Convert temporary values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}