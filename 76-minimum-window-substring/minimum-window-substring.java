import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: store frequency of t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            // Step 2: reduce count if char is needed
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }

            // Step 3: valid window
            while (count == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }

                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}