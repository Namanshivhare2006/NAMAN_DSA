// class Solution {
//     public boolean isHappy(int n) {
//         if(n==1 || n==7) return true;
//         else if(n<10) return false;
//         else{
//             int sum=0;
//             while(n>0){
//                 int temp=n%10;
//                 sum+= temp*temp;
//                 n=n/10;
//             }
//             return isHappy(sum);
//         }
//     }
// }
import java.util.*;

class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {

            set.add(n);

            int sum = 0;

            while (n > 0) {

                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }
}