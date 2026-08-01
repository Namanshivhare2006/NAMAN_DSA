class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;

        int[] startTime = new int[m];
        int[] endTime = new int[m];

        for (int i = 0; i < m; i++) {
            startTime[i] = flowers[i][0];
            endTime[i] = flowers[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int time = people[i];

            int bloomedFlowers = upperBound(startTime, time);
            int diedFlowers = lowerBound(endTime, time);

            result[i] = bloomedFlowers - diedFlowers;
        }

        return result;
    }

    // First index > target
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // First index >= target
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}