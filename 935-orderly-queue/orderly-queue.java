class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char []arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        String res = s;
        int n = s.length();

        for(int i = 1; i<n; i++){
            String temp = s.substring(i) + s.substring(0,i);
            if(temp.compareTo(res)<0){
                res = temp;
            }
        }
        return res;
    }
}