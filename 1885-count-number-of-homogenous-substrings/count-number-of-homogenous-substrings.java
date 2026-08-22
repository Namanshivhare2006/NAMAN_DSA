class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        long sum = 0;
        char cur = ' ';
        
        for(char c : s.toCharArray()){
            if(c != cur){
                cur = c;
                count = 1;
                sum++;
            }else{
                count++;
                sum = sum + count;
            }
        }

        return (int)((sum) % (Math.pow(10, 9) + 7));
    }
}