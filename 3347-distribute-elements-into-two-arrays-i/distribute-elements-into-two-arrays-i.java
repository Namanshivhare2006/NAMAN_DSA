class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int ans1[] = new int[n];
        int ans2[] = new int[n];
        ans1[0] = nums[0];
        ans2[0] = nums[1];

        int i = 1;
        int j = 1;
        for (int k = 2; k < n; k++) {
            if (ans1[i - 1] < ans2[j - 1]) {
                ans2[j] = nums[k];
                j++;
            }else{
            ans1[i] = nums[k];
            i++;}
        }
        for (int f = 0; f < j; f++) {
            ans1[i] = ans2[f];
            i++;

        }
        return ans1;
    }
}