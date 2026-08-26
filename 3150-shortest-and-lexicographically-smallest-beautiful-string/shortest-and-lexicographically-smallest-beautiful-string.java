class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        for (int len = k; len <= n; len++) {
            String res = "";

            for (int i = 0; i <= n - len; i++) {
                String temp = s.substring(i, i + len);

                int one = 0;

                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '1') {
                        one++;
                    }
                }

                if (one == k) {
                    if (res.isEmpty() || temp.compareTo(res) < 0) {
                        res = temp;
                    }
                }
            }

            if (!res.isEmpty()) {
                return res;
            }
        }

        return "";
    }
}