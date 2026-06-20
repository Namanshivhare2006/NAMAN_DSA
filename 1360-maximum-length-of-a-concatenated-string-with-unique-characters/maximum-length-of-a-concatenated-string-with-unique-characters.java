class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        String temp = "";  //no concatenation till now
        int i = 0;
        return solve(i,arr,temp,n);
    }
    public int solve(int i, List<String> arr,String temp, int n){
        if(i>=n){
            return temp.length();
        }
        int include = 0;
        int exclude = 0;
        if(hasDupi(temp,arr.get(i))){
            //excliude
            exclude = solve(i+1,arr,temp,n);
        }else{
            exclude = solve(i+1,arr,temp,n);
            include = solve(i+1, arr,temp+arr.get(i),n);
        }
        return Math.max(include,exclude);

    }
    boolean hasDupi(String s1, String s2) {
    boolean[] seen = new boolean[26];

    // Check duplicates in s1
    for (char ch : s1.toCharArray()) {
        int idx = ch - 'a';
        if (seen[idx]) return true;
        seen[idx] = true;
    }

    // Check duplicates in s2 and common chars with s1
    boolean[] seen2 = new boolean[26];

    for (char ch : s2.toCharArray()) {
        int idx = ch - 'a';

        // Common character between s1 and s2
        if (seen[idx]) return true;

        // Duplicate inside s2
        if (seen2[idx]) return true;

        seen2[idx] = true;
    }

    return false;
}
}