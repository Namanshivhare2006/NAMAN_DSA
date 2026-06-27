class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long)x, freq.getOrDefault((long)x, 0) + 1);
        }

        int ans = 1;

        // Special handling for 1
        if (freq.containsKey(1L)) {
            int c = freq.get(1L);
            ans = Math.max(ans, (c % 2 == 1) ? c : c - 1);
        }

        for (long start : freq.keySet()) {
            if (start == 1) continue;

            long x = start;
            int len = 0;

            while (freq.getOrDefault(x, 0) >= 2) {
                len += 2;
                x = x * x;
            }

            if (freq.containsKey(x))
                len += 1;
            else
                len -= 1;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}