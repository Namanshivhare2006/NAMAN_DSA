class Solution {
    public long minCost(int[] nums, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int num : nums){
            left = Math.min(left,num);
            right = Math.max(right,num);
        }

        long ans = Integer.MAX_VALUE;

        while(left<=right){
            int mid = left + (right - left)/2;

            long cost1 = findCost(nums,cost,mid);
            long cost2 = findCost(nums,cost,mid + 1);

            ans = Math.min(cost1,cost2);

            if(cost2>cost1){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public long findCost(int []nums, int []cost , int target){
        long res = 0;
        for(int i = 0; i<nums.length; i++){
            res+= (long)Math.abs(nums[i] - target) * cost[i];
        }
        return res;


    }
}