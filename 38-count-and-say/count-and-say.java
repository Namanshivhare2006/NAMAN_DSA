class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";

        String prev = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int c = 1;

        for(int i = 1; i<prev.length(); i++){
            if(prev.charAt(i)==prev.charAt(i-1)){
                c++;
            }else{
                ans.append(c);
                ans.append(prev.charAt(i - 1));
                c = 1;
            }
        }
        ans.append(c);
        ans.append(prev.charAt(prev.length() - 1));
        return ans.toString();
    }
}