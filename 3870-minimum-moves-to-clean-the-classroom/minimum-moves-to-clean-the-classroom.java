class Solution {

    static class State {
        int r, c, mask, energy, steps;

        State(int r, int c, int mask, int energy, int steps) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0, startC = 0;

        // Give every litter cell an index
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        // Already clean
        if (fullMask == 0) {
            return 0;
        }

        /*
         * best[r][c][mask] =
         * maximum energy with which we have reached
         * (r, c) after collecting 'mask'.
         */
        int[][][] best = new int[m][n][1 << litterCount];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(best[i][j], -1);
            }
        }

        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(startR, startC, 0, energy, 0));
        best[startR][startC][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State cur = queue.poll();

            if (cur.mask == fullMask) {
                return cur.steps;
            }

            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // Outside classroom
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                char cell = classroom[nr].charAt(nc);

                // Wall
                if (cell == 'X') {
                    continue;
                }

                // Need energy to make a move
                if (cur.energy == 0) {
                    continue;
                }

                int newEnergy = cur.energy - 1;

                // Recharge at R
                if (cell == 'R') {
                    newEnergy = energy;
                }

                int newMask = cur.mask;

                // Collect litter
                if (cell == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                /*
                 * If we have already reached the same state
                 * with MORE energy, this state is useless.
                 */
                if (best[nr][nc][newMask] >= newEnergy) {
                    continue;
                }

                best[nr][nc][newMask] = newEnergy;

                queue.offer(
                    new State(
                        nr,
                        nc,
                        newMask,
                        newEnergy,
                        cur.steps + 1
                    )
                );
            }
        }

        return -1;
    }
}