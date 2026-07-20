class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {

        int n = txt.length();
        List<Integer> res = new ArrayList<>();

        if (pat.length() > txt.length()) {
            return res;
        }

        int[] count = new int[26];

        for (int i = 0; i < pat.length(); i++) {
            count[pat.charAt(i) - 'a']++;
        }

        int i = 0, j = 0;
        int k = pat.length();

        while (j < n) {

            count[txt.charAt(j) - 'a']--;

            if (j - i + 1 == k) {

                if (allzero(count)) {
                    res.add(i);
                }

                count[txt.charAt(i) - 'a']++;
                i++;
            }

            j++;
        }

        return res;
    }

    public boolean allzero(int[] count) {
        for (int x : count) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}