class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int count = 0;

        // Outer character manually check
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = -1;
            int last = -1;

            // Find first and last occurrence manually
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    
                    if (first == -1) {
                        first = i;
                    }

                    last = i;
                }
            }

            // If same character appears with something in between
            if (first != -1 && last - first >= 2) {

                boolean[] seen = new boolean[26];

                // Check middle characters manually
                for (int i = first + 1; i < last; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }

                // Count unique middle characters
                for (int i = 0; i < 26; i++) {
                    if (seen[i]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}