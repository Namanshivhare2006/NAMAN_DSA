class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int l = 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            long hour = 0;

            for (int pile : piles) {
                hour += (pile + mid - 1L) / mid;
            }

            if (hour > h) {
                l = mid + 1;  // speed too slow
            } else {
                r = mid;      // speed works, try smaller
            }
        }

        return l;
    }
}