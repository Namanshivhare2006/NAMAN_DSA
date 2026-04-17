class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int firstOccurrence = map.get(nums[i]);
                minDistance = Math.min(minDistance, i - firstOccurrence);

                int reversedNum = reverseNumber(nums[i]);
                map.put(reversedNum, i);
            } else {
                int reversedNum = reverseNumber(nums[i]);
                map.put(reversedNum, i);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}