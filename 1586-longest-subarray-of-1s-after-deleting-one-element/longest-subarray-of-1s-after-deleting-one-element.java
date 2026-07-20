// class Solution {
//     public int longestSubarray(int[] nums) {
//         int n = nums.length;
//         int res = 0;
//         int countZ = 0;
//         for(int i = 0; i<n; i++){
//             if(nums[i]==0){
//                 countZ++;
//                 res = Math.max(res, findmax(nums,i));
//             }
//         }
//         return countZ==0?n-1:res;
        
//     }
//     int findmax(int nums[], int skip){
//         int curL = 0;
//         int maxL = 0;
        
//         for(int i = 0; i<nums.length; i++){
//             if(i==skip){
//                 continue;
//             }
//             if(nums[i]==1){
//                 curL++;
//                 maxL = Math.max(maxL, curL);
//             }else{
//                 curL = 0;
//             }
//         }
//         return maxL;

//     }
// }
class Solution {
    public int longestSubarray(int[] nums) {

        int i = 0;
        int zeroCount = 0;
        int ans = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}