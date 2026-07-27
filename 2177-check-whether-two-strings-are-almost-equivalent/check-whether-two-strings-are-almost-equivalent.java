class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int len = word1.length();
        int []fre = new int[26];
        for(int i = 0; i<len; i++){
            fre[word1.charAt(i) - 'a']++;
            fre[word2.charAt(i) - 'a']--;
        }
        for(int i = 0; i<26; i++){
            if(Math.abs(fre[i])>3){
                return false;
            }
        }
        return true;
    }
}