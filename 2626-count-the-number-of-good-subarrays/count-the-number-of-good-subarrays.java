class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        long pairs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            // Existing occurrences of nums[j] form new pairs
            pairs += map.getOrDefault(nums[j], 0);

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (pairs >= k) {
                result += (n - j);

                map.put(nums[i], map.get(nums[i]) - 1);

                // After removing nums[i], reduce the number of pairs
                pairs -= map.get(nums[i]);

                i++;
            }

            j++;
        }

        return result;
    }
}