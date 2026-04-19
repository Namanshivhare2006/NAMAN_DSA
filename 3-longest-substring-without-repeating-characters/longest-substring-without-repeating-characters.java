class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        Set<Character> seen = new HashSet<>();
        int count = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if ( seen.add(c)) {
                
                count = Math.max(count, r - l + 1);
                r++;
            } else {
                seen.remove(s.charAt(l));
                l++;
            }
        }

        return count;
    }
}