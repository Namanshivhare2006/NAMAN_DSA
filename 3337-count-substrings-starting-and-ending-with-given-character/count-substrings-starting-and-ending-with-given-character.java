class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long total = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==c){
             total = total + 1 + count;
             count++;
            }
        }
        return total;       
    }
}