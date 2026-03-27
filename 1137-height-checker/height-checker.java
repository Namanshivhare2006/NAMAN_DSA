class Solution {
    public int heightChecker(int[] heights) {
        // int[] sorted = new int[heights.length];
        // for(int i =0; i < heights.length; i++) {
        //     sorted[i] = heights[i];
        // }
    //    int[] sorted = Arrays.copyOf(heights, heights.length);
            int[] sorted  = heights.clone();

        Arrays.sort(sorted);

        int total = 0;
        for(int i =0; i < heights.length; i++) {
            if(sorted[i] != heights[i]) total++;
        }

        return total;
    }
}