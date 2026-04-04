// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] result = new int[n - k + 1];

//         for (int i = 0; i <= n - k; i++) {
//             int max = nums[i];
//             for (int j = i; j < i + k; j++) {
//                 max = Math.max(max, nums[j]);
//             }

//             result[i] = max;
//         }

//         return result;
//     }
// }
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Remove out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}