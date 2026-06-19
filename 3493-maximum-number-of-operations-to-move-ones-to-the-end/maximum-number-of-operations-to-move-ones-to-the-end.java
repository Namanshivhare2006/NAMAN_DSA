class Solution {
    public int maxOperations(String s) {
        int ones = 0;
        int operations = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }

            if (i < s.length() - 1 &&
                s.charAt(i) == '1' &&
                s.charAt(i + 1) == '0') {

                operations += ones;
            }
        }

        return operations;
    }
}