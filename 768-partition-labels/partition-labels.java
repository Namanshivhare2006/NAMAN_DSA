class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] last = new int[26];

        // Store last occurrence
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        

       int start = 0;
        int end = 0;

      int  i = 0;
        while (i < s.length()) {

            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }

            i++;
        }

        return ans;
    }
}