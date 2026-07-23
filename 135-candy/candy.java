// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int left[] = new int[n];
//         int right[] = new int[n];
//         Arrays.fill(left,1);
//          Arrays.fill(right,1);

//         for(int i = 1; i<n; i++){
//             if(ratings[i]>ratings[i-1]){
//                 left[i] = Math.max(left[i], left[i-1]+1);
//             }
//         }

//          for(int i = n-2; i>=0; i--){
//             if(ratings[i]>ratings[i+1]){
//                 right[i] = Math.max(right[i], right[i+1]+1);
//             }
//         }
//         int res = 0;
//         for(int i = 0; i<n; i++){
//             res+=Math.max(left[i], right[i]);
//         }
//         return res;
//     }
// }
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        int res = candy[n - 1];

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            res += candy[i];
        }

        return res;
    }
}