class Solution {
    public int minimizeArrayValue(int[] nums) {

        int maxL = 1;
        int maxR = 0;
        for(int n : nums){
            maxR= Math.max(maxR,n);
        }
  int res = 0;
        while(maxL<=maxR){
            int mid_max = maxL + (maxR - maxL)/2;
          
           if(isValid(nums, mid_max)){
            res = mid_max;
            maxR =mid_max - 1;
           }else{
maxL = mid_max + 1;
           }

        }
        return res;
        
    }
    public boolean isValid(int nums[],int mid_max){
        int n = nums.length;
        long[] arr = new long[nums.length];
           for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

  for(int i = 0; i<nums.length-1; i++){
    if(arr[i]>mid_max){
        return false;
    }
    long buffer = mid_max - arr[i];
    arr[i+1] = arr[i+1] - buffer;
  }
  return arr[nums.length-1]<=mid_max;
    }
}