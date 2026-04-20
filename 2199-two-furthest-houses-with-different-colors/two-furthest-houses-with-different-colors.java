// class Solution {
//     public int maxDistance(int[] colors) {
//         int n = colors.length;
//         int max = 0;

//         // Compare with first element
//         for(int i = n - 1; i >= 0; i--){
//             if(colors[i] != colors[0]){
//                 max = Math.max(max, i);
//                 break;
//             }
//         }

//         // Compare with last element
//         for(int i = 0; i < n; i++){
//             if(colors[i] != colors[n - 1]){
//                 max = Math.max(max, n - 1 - i);
//                 break;
//             }
//         }

//         return max;
//     }
// }
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        
        int left = 0;
        int right = n - 1;
        
        // Fix left, move right
        while(colors[left] == colors[right]) {
            right--;
        }
        int ans = right - left;
        
        // Fix right, move left
        left = 0;
        while(colors[left] == colors[n - 1]) {
            left++;
        }
        ans = Math.max(ans, (n - 1) - left);
        
        return ans;
    }
}