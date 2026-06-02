class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        String max = s;
        for(char c : s.toCharArray()){
            if(c!='9'){
                max = s.replace(c,'9');
                break;
            }
        }
String min = s;
         if (s.charAt(0) != '1') {
            min = s.replace(s.charAt(0), '1');
        } else {
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '0' && c != '1') {
                    min = s.replace(c, '0');
                    break;
                }
            }
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}