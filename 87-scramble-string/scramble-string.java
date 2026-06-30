// class Solution {
//     public boolean isScramble(String s1, String s2) {
//         return solve(s1, s2);
//     }

//     public boolean solve(String s1, String s2) {

//         if (s1.equals(s2))
//             return true;

//         if (s1.length() != s2.length())
//             return false;

//         int n = s1.length();

//         if (n <= 1)
//             return false;

//         for (int i = 1; i < n; i++) {

//             // Swapped
//             if (solve(s1.substring(0, i), s2.substring(n - i)) &&
//                 solve(s1.substring(i), s2.substring(0, n - i)))
//                 return true;

//             // Not swapped
//             if (solve(s1.substring(0, i), s2.substring(0, i)) &&
//                 solve(s1.substring(i), s2.substring(i)))
//                 return true;
//         }

//         return false;
//     }
// }

import java.util.HashMap;

class Solution {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        return solve(s1, s2);
    }

    public boolean solve(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        String key = s1 + "#" + s2;

        if (memo.containsKey(key))
            return memo.get(key);

        int n = s1.length();

        if (n <= 1)
            return false;

        for (int i = 1; i < n; i++) {

            // Swapped
            if (solve(s1.substring(0, i), s2.substring(n - i)) &&
                solve(s1.substring(i), s2.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }

            // Not Swapped
            if (solve(s1.substring(0, i), s2.substring(0, i)) &&
                solve(s1.substring(i), s2.substring(i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}