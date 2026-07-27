class Solution {
    public int maxProduct(int[] nums) {
        int max  = 0;
        int preproduct = 0;

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int p = nums[i]*nums[j];
                if(p>max){
                    max = p;
                    preproduct = (nums[i]-1)*(nums[j]-1);
                }
            }
        }
        return preproduct;
        
    }
}