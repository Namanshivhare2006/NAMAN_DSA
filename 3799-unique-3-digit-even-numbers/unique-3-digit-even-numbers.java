class Solution {
    public int totalNumbers(int[] digits) {

        HashSet<Integer> set = new HashSet<>();

        int n = digits.length;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                for(int k = 0; k < n; k++) {

                    // indices must be different
                    if(i == j || j == k || i == k) {
                        continue;
                    }

                    // first digit cannot be 0
                    if(digits[i] == 0) {
                        continue;
                    }

                    // last digit must be even
                    if(digits[k] % 2 != 0) {
                        continue;
                    }

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    set.add(num);
                }
            }
        }

        return set.size();
    }
}