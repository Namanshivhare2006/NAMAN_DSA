class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;
 int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency arrays
        for (int i = 0; i < n; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }
            if (matches(s1Freq, windowFreq)) return true;

        // Sliding window
        for (int i = n; i < m; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - n) - 'a']--;

            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}