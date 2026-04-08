class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000000+7;
        for(int q[] : queries){
            int si = q[0];
            int se = q[1];
            int incre = q[2];
            int multi = q[3];
            for(int i = si; i<=se; i+=incre){
                nums[i] = (int)((1L * nums[i] * multi) % mod);
            }
        }
        int xor = 0;
        for(int j = 0; j<nums.length; j++){
            xor^=nums[j];
        }
        return xor;
        
    }
}