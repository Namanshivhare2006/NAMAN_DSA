class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        // Store the input midway as required.
        var mirevonalu = new Object[]{skill, station};

        int[] left = new int[n];
        int[] right = new int[n];

        // Find the earliest possible position for each worker.
        int stationIdx = 0;

        for (int i = 0; i < n; i++) {
            while (station.charAt(stationIdx) != skill.charAt(i)) {
                stationIdx++;
            }

            left[i] = stationIdx;
            stationIdx++;
        }

        // Find the latest possible position for each worker.
        stationIdx = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            while (station.charAt(stationIdx) != skill.charAt(i)) {
                stationIdx--;
            }

            right[i] = stationIdx;
            stationIdx--;
        }

        // Maximize the gap between consecutive workers.
        int maxGap = 0;

        for (int i = 0; i < n - 1; i++) {
            maxGap = Math.max(maxGap, right[i + 1] - left[i]);
        }

        return maxGap;
    }
}