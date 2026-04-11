import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store indices of each number
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // Check each number's indices
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int dist = 2 * (list.get(i + 2) - list.get(i));
                    ans = Math.min(ans, dist);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}