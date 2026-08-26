// class Solution {
//     public String decodeAtIndex(String s, int k) {
//         StringBuilder sb = new StringBuilder();

//         for(int i = 0; i<s.length(); i++){
//             char ch = s.charAt(i);

//             if(Character.isLetter(ch)){
//                 sb.append(ch);
//             }
//             if(Character.isDigit(ch)){
              
//                 String current = sb.toString();

//                 for (int j = 1; j < ch-'0'; j++) {
//                     sb.append(current);
//                 }
//             }
//         }
//        return String.valueOf(sb.charAt(k - 1));
        
//     }
// }
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // Calculate decoded string length
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {
                size++;
            } else {
                size *= (ch - '0');
            }
        }

        // Find kth character by going backwards
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            k %= size;

            if (k == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }

            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}