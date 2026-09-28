class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int open = 0;
        for (final char ch : s.toCharArray()) {
            if (ch == '(') {
                ans = Math.max(ans, ++open);

            } else if (ch == ')') {

                --open;
            }
        }
        return ans;
    }
}