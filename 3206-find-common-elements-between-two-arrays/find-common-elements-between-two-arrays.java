class Solution {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // store nums1 elements
        for(int num : nums1) {
            set1.add(num);
        }

        // store nums2 elements
        for(int num : nums2) {
            set2.add(num);
        }

        int answer1 = 0;
        int answer2 = 0;

        // count nums1 elements present in nums2
        for(int num : nums1) {

            if(set2.contains(num)) {
                answer1++;
            }
        }

        // count nums2 elements present in nums1
        for(int num : nums2) {

            if(set1.contains(num)) {
                answer2++;
            }
        }

        return new int[]{answer1, answer2};
    }
}