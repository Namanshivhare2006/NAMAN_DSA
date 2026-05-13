class Solution {
    public int arraySign(int[] nums) {
        
        // if (nums.length == 0){
        //     return 0;
        // }
        double p = 1;

        for(int i = 0; i < nums.length; i++){
            p *= nums[i];
            
        }

        if(p > 0) return 1;
       else if(p < 0) return -1;

        return 0;
    }
}