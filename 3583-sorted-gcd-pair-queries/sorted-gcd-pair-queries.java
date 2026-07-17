class Solution {
    public int[] gcdValues(int[] arr, long[] queries) {
        int n = arr.length;
        int[] ans = new int[queries.length];

        int maxVal = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ele : arr) {
            if (ele > maxVal) maxVal = ele;
            countMap.put(ele, countMap.getOrDefault(ele, 0) + 1);
        }

        Map<Integer, Long> gcdPairMap = new HashMap<>();
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += countMap.getOrDefault(j, 0);
            }
            
            long totalPairs = (totalMultiples * (totalMultiples - 1)) / 2;
            
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdPairMap.getOrDefault(j, 0L);
            }
            gcdPairMap.put(i, totalPairs);
        }

        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdPairMap.getOrDefault(i, 0L);
        }

        for (int k = 0; k < queries.length; k++) {
            long target = queries[k];
            int low = 1, high = maxVal;
            int exactGcd = maxVal;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > target) {
                    exactGcd = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[k] = exactGcd;
        }

        return ans;
    }

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}