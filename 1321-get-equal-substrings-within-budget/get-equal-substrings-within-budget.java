class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0, j = 0;
        int curCost = 0;
        int maxLen = 0;

        while(j<n){
            curCost += Math.abs(s.charAt(j) - t.charAt(j)); 
            while(curCost>maxCost){
                curCost-=Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}