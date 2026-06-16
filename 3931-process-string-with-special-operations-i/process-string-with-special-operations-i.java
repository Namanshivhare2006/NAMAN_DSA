class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch=='#'){
                if(sb.length()>0){
                    sb.append(sb.toString());
                }
            }
            else if(ch =='*'){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else if(ch=='%'){
                if(sb.length()>0){
                    sb.reverse();
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}