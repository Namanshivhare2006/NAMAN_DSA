class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] c = new int[3];
        for (int n : stones) c[n % 3]++;
        if ((c[0] & 1) == 0) return c[1] > 0 && c[2] > 0;
        return Math.abs(c[1] - c[2]) > 2;
    }
}