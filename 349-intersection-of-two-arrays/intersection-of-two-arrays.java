class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        
        // Nested loop जैसा आपने लिखा था
        for(int num1 : nums1){
            for(int num2 : nums2){
                if(num1 == num2){
                    res.add(num1);
                    break; // duplicate बार-बार add न हो
                }
            }
        }

        // Set को array में बदलना
        int[] arr = new int[res.size()];
        int i = 0;
        for(int num : res){
            arr[i++] = num;
        }
        return arr;
    }
}