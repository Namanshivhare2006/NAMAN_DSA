class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
         StringBuilder s2 = new StringBuilder();
      for(String st1 : word1){
        s1.append(st1);
      }
         for(String st2 : word2){
        s2.append(st2);
      }
      return s1.toString().equals(s2.toString());
    }
}