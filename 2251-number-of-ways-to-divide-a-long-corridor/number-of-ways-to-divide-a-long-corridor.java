class Solution {
    public int numberOfWays(String corridor) {

        int n = corridor.length();

        // Store indices of seats
        int[] posSeats = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                posSeats[count] = i;
                count++;
            }
        }

        // Number of seats must be even and non-zero
        if (count == 0 || count % 2 != 0) {
            return 0;
        }

        long result = 1;
        long M = 1000000007;

        // End index of previous 2-seat section
        int endIdxPrev = posSeats[1];

        // Start from the 3rd seat
        for (int i = 2; i < count; i += 2) {

            // Number of possible positions for divider
            int length = posSeats[i] - endIdxPrev;

            result = (result * length) % M;

            // End index of current 2-seat section
            endIdxPrev = posSeats[i + 1];
        }

        return (int) result;
    }
}