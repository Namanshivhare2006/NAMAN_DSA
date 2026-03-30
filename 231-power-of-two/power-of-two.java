// class Solution {
//     public boolean isPowerOfTwo(int n) {
//         if(n<=0) return false;
//         if(n==1) return true;
//         return (n%2==0) && isPowerOfTwo(n/2);
//     }
// }
class Solution {
    public boolean isPowerOfTwo(int n){
        if(n<=0) return false;
        return (n & (n - 1)) == 0;
    }
}