class Solution {
    public String removeDuplicateLetters(String s) {
        boolean taken[] = new boolean[26];
        int lastidx[] = new int[26];

        for(int i = 0; i<s.length(); i++){
         lastidx[s.charAt(i) - 'a'] = i;   
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';

            //ifcharacter is already taken
          if(taken[idx]){
            continue;
          }
          while(sb.length()>0 && sb.charAt(sb.length() - 1)> ch && lastidx[sb.charAt(sb.length() - 1) - 'a']>i){
            char lastchar = sb.charAt(sb.length()-1);
            taken[lastchar - 'a'] = false;
            sb.deleteCharAt(sb.length() - 1);
          }
          sb.append(ch);
          taken[idx] = true;
        }
        return sb.toString();

    }
}