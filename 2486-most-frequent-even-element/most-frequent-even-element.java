class Solution {
    public int mostFrequentEven(int[] nums) {
        
          HashMap<Integer, Integer> map = new HashMap<>();

        // count frequency of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
           int maxFreq = 0;
        int result = -1;

        // find answer
        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq > maxFreq || (freq == maxFreq && key < result)) {
                maxFreq = freq;
                result = key;
            }
        }

        return result;
    }
}