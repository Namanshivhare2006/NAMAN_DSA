class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        int ans = 0;

        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
                continue;
            }

            int k = j;
            while (k > i && arr[k] != arr[i]) {
                k--;
            }

            if (k == i) {
                swap(arr, i, i + 1);
                ans++;
            } else {
                while (k < j) {
                    swap(arr, k, k + 1);
                    ans++;
                    k++;
                }
                i++;
                j--;
            }
        }

        return ans;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}