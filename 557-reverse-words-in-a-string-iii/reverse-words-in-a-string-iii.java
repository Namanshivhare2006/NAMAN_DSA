class Solution {
    public String reverseWords(String s) {
         String[] words = s.trim().split("\\s+");
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < words.length; i++){
            StringBuilder temp = new StringBuilder(words[i]);
            result.append(temp.reverse());
            
            if(i != words.length - 1){
                result.append(" "); // add single space
            }
        }
        
        return result.toString();
    }
}