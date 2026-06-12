class Solution {
    public int minDeletions(String s) {
        int []fre = new int[26];

        for(char ch : s.toCharArray()){
            fre[ch - 'a']++;

        }
        HashSet<Integer> used = new HashSet<>();
        int dele = 0;

        for(int f : fre){
            while((f>0) && used.contains(f)){
                f--;
                dele++;
            }
            if(f>0){
                used.add(f);
            }
        }
        return dele;
    }
}