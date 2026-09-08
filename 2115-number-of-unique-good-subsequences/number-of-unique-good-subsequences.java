// class Solution {
//     public int numberOfUniqueGoodSubsequences(String binary) {
//         HashSet<String> st = new HashSet<>();

//         help(0, binary, "",st);
//         int count = 0;
//         for(String x : st){
//             if(x.length()==1){
//                 count++;
//             }else if(x.charAt(0)!='0'){
//                 count++;
//             }
//         }
//         return count;

//     }

//     public void help(int i, String binary, String sub,HashSet<String> st) {
      
//         if (i == binary.length()) {
//             if (sub.length() > 0) {
//                 st.add(sub);
//             }
//             return ;
//         }

//         help(i + 1, binary, sub + binary.charAt(i),st);
//         help(i + 1, binary, sub,st);
      

//     }
// }

class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {

        final int MOD = 1000000007;

        long dp0 = 0;
        long dp1 = 0;
        boolean hasZero = false;

        for (char ch : binary.toCharArray()) {

            if (ch == '0') {
                hasZero = true;

                // New subsequences ending with 0
                dp0 = (dp0 + dp1) % MOD;

            } else {

                // New subsequences ending with 1
                dp1 = (dp0 + dp1 + 1) % MOD;
            }
        }

        return (int)((dp0 + dp1 + (hasZero ? 1 : 0)) % MOD);
    }
}