class Solution {
    public long largestPerimeter(int[] nums) {
     Arrays.sort(nums);

     long param = 0;
     long remainsum = 0;

     for(int i = 0; i<nums.length; i++) {
        if(nums[i]<remainsum){
            param = remainsum + nums[i];

        }
        remainsum+=nums[i];
     }  
     return param==0?-1:param;
    }
}