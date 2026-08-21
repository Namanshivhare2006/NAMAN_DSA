class Solution {
    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        // If both strings are already equal
        if (s.equals(goal)) {

            // Check if any character appears more than once
            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;

                if (freq[ch - 'a'] >= 2) {
                    return true;
                }
            }

            return false;
        }

        // Find different positions
        int first = -1;
        int second = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != goal.charAt(i)) {

                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false; // More than 2 differences
                }
            }
        }

        // Check if swapping makes strings equal
        return second != -1
                && s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first);
    }
}