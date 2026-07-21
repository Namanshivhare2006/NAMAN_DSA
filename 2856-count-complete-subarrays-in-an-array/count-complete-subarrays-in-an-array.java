class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // Count total distinct elements
        int totalDistinct = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) totalDistinct++;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int distinct = 0;

            for (int j = i; j < n; j++) {
                boolean found = false;
                for (int k = i; k < j; k++) {
                    if (nums[k] == nums[j]) {
                        found = true;
                        break;
                    }
                }

                if (!found) distinct++;

                if (distinct == totalDistinct)
                    ans++;
            }
        }

        return ans;
    }
}