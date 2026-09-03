class Solution {
    public boolean uniformArray(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int oc = 0;
        for(int i = 0; i<nums.length;i++)
            {}
        for(int num:nums){
            if(num%2==1){
                oc++;
            }
        }
        if(oc==0) return true;
        if(min%2==1) return true;
        return false;
    }
}