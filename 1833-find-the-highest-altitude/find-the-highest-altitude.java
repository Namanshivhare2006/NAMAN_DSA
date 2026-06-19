class Solution {
    public int largestAltitude(int[] gain) {
       int altitute = 0;
       int maxAlti = 0;
       for(int num : gain){
        altitute+=num;
        maxAlti = Math.max(maxAlti,altitute);
       }
        return maxAlti;
    }
   
}