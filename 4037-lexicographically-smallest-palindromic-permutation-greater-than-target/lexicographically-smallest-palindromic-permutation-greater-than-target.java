class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // A palindrome can have at most one odd-frequency character.
        int oddChar = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                if (oddChar != -1) {
                    return "";
                }
                oddChar = i;
            }
        }

        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCount[i] = freq[i] / 2;
        }

        /*
         * First check whether target's complete left half can be used.
         * If so, construct the smallest palindrome having that left half.
         */
        int[] remaining = halfCount.clone();
        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            remaining[c]--;
        }

        if (possible) {
            String candidate = buildPalindrome(target.substring(0, half), remaining, oddChar);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Try to make the first difference at every position
         * in the left half, starting from the right.
         */
        for (int i = half - 1; i >= 0; i--) {
            remaining = halfCount.clone();

            // Keep target[0 ... i-1] unchanged.
            boolean validPrefix = true;

            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';

                if (remaining[c] == 0) {
                    validPrefix = false;
                    break;
                }

                remaining[c]--;
            }

            if (!validPrefix) {
                continue;
            }

            int targetChar = target.charAt(i) - 'a';

            // Choose the smallest available character > target[i].
            int nextChar = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    nextChar = c;
                    break;
                }
            }

            if (nextChar == -1) {
                continue;
            }

            remaining[nextChar]--;

            StringBuilder left = new StringBuilder();

            // Target prefix.
            left.append(target, 0, i);

            // First character that makes us greater.
            left.append((char) ('a' + nextChar));

            // Fill the rest with the smallest available characters.
            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    left.append((char) ('a' + c));
                    remaining[c]--;
                }
            }

            String candidate = buildPalindrome(left.toString(), remaining, oddChar);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        return "";
    }

    private String buildPalindrome(String left, int[] remaining, int oddChar) {
        StringBuilder result = new StringBuilder();

        result.append(left);

        if (oddChar != -1) {
            result.append((char) ('a' + oddChar));
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}