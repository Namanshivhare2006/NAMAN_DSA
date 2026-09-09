class Solution {
    public long countCommas(long n) {
        long ans = 0;
     for(int i = 3; i<=15; i+=3){
         long s = (long)Math.pow(10,i);
         if(s>n)break;
         long e = Math.min(n,(long)Math.pow(10,i+3)-1);
         long count = e - s + 1;
         long c = i/3;
         ans+=count*(i/3);
     }   
        return ans;
    }
}