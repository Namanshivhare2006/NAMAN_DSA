class Solution {
    public boolean backspaceCompare(String s, String t) {
        return check(s).equals(check(t));
        
    }
    public String check(String str){
        StringBuilder res = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(ch!='#'){
                res.append(ch);
            }else if(res.length()>0){
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }
}