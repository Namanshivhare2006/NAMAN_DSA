

class Solution {

    Set<String> st = new HashSet<>();
    int maxLen = 0;
    int n;

    void solve(String s, int i, StringBuilder curr, int count) {

        // Base case
        if (i == n) {

            // If parentheses are balanced
            if (count == 0) {

                int len = curr.length();

                if (len > maxLen) {
                    st.clear();
                    maxLen = len;
                    st.add(curr.toString());
                }
                else if (len == maxLen) {
                    st.add(curr.toString());
                }
            }

            return;
        }

        char ch = s.charAt(i);

        // Alphabet / normal character
        if (ch != '(' && ch != ')') {

            curr.append(ch);

            solve(s, i + 1, curr, count);

            curr.deleteCharAt(curr.length() - 1);

            return;
        }

        // --------------------------------
        // Choice 1: Remove current char
        // --------------------------------
        solve(s, i + 1, curr, count);


        // --------------------------------
        // Choice 2: Keep current char
        // --------------------------------

        curr.append(ch);

        if (ch == '(') {

            // '(' increases balance
            solve(s, i + 1, curr, count + 1);

        }
        else {

            // ')' can be kept only if
            // there is an unmatched '('
            if (count > 0) {
                solve(s, i + 1, curr, count - 1);
            }
        }

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);
    }

    public List<String> removeInvalidParentheses(String s) {

        n = s.length();

        st.clear();
        maxLen = 0;

        StringBuilder curr = new StringBuilder();

        solve(s, 0, curr, 0);

        return new ArrayList<>(st);
    }
}