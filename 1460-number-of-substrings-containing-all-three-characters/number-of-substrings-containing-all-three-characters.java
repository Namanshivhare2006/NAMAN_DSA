// class Solution {
//     public int numberOfSubstrings(String s) {
//         int[]lastChar={-1,-1,-1};
//         int ans=0;
//         for(int i=0;i<s.length();i++){
//             lastChar[s.charAt(i)-'a']=i;
//             ans+=1+Math.min(lastChar[0],Math.min(lastChar[1],lastChar[2]));
//         }
//         return ans;
//     }
// }
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int[] freq = new int[3];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += (n - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}