class Solution {
    public String sortVowels(String s) {
     List<Character> list = new ArrayList<>();

       for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                list.add(ch);
            }
        }
    Collections.sort(list);
     char[] arr = s.toCharArray();

        int index = 0;

        // Step 3: Replace vowels with sorted vowels
        for (int i = 0; i < arr.length; i++) {

            if ("AEIOUaeiou".indexOf(arr[i]) != -1) {
                arr[i] = list.get(index);
                index++;
            }
        }

        return new String(arr);
    }
}