// class Solution {
//     public String sortVowels(String s) {
//      List<Character> list = new ArrayList<>();

//        for (char ch : s.toCharArray()) {
//             if ("AEIOUaeiou".indexOf(ch) != -1) {
//                 list.add(ch);
//             }
//         }
//     Collections.sort(list);
//      char[] arr = s.toCharArray();

//         int index = 0;

//         // Step 3: Replace vowels with sorted vowels
//         for (int i = 0; i < arr.length; i++) {

//             if ("AEIOUaeiou".indexOf(arr[i]) != -1) {
//                 arr[i] = list.get(index);
//                 index++;
//             }
//         }

//         return new String(arr);
//     }
// }
import java.util.*;

class Solution {
    public String sortVowels(String s) {

        List<Character> vowels = new ArrayList<>();

        // Fetch vowels manually
        for (char ch : s.toCharArray()) {

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U') {

                vowels.add(ch);
            }
        }

        // Sort vowels
        Collections.sort(vowels);

        char[] arr = s.toCharArray();
        int j = 0;

        // Put sorted vowels back
        for (int i = 0; i < arr.length; i++) {

            char ch = arr[i];

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U') {

                arr[i] = vowels.get(j++);
            }
        }

        return new String(arr);
    }
}