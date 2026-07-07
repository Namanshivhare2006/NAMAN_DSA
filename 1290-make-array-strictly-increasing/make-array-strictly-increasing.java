

class Solution {

    HashMap<String, Integer> dp = new HashMap<>();
    int INF = (int)1e9;

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {

        Arrays.sort(arr2);

        // Remove duplicates
        int m = 0;
        for (int x : arr2) {
            if (m == 0 || arr2[m - 1] != x) {
                arr2[m++] = x;
            }
        }

        arr2 = Arrays.copyOf(arr2, m);

        int ans = solve(0, arr1, arr2, Integer.MIN_VALUE);

        return ans >= INF ? -1 : ans;
    }

    private int solve(int idx, int[] arr1, int[] arr2, int prev) {

        if (idx == arr1.length)
            return 0;

        String key = idx + "#" + prev;

        if (dp.containsKey(key))
            return dp.get(key);

        int result1 = INF;

        // Don't replace
        if (arr1[idx] > prev) {
            result1 = solve(idx + 1, arr1, arr2, arr1[idx]);
        }

        int result2 = INF;

        // Replace
        int j = upperBound(arr2, prev);

        if (j != arr2.length) {
            result2 = 1 + solve(idx + 1, arr1, arr2, arr2[j]);
        }

        int ans = Math.min(result1, result2);
        dp.put(key, ans);

        return ans;
    }

    // Returns index of first element greater than target
    private int upperBound(int[] arr, int target) {

        int low = 0, high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}