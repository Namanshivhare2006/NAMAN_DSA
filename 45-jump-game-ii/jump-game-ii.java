class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int max = 0;
        int currend = 0;
        for(int i = 0; i<nums.length-1; i++){
             max = Math.max(max, nums[i] + i);
           if(i == currend){
            count++;
            currend = max;
           }
        }
        return count;
    }
}          