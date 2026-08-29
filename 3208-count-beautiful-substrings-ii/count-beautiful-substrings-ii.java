class Solution {
    public long beautifulSubstrings(String s, int k) {
     int n = s.length();
     //find smallest m so that m *m divisible by k
     int m = 1;
     while((long)m*m%k!=0){
        m++;
     }   

     int period = 2*m;

     //map prefixsum count indices for each reminder
     Map<Integer, long[]>map = new HashMap<>();

     long ans = 0;
     int pre = 0;

     //prefix before index 0

     map.put(0, new long[period]);
     map.get(0)[0] = 1;
     for(int i = 0; i<n; i++){
        char c = s.charAt(i);
        if(c == 'a' ||
               c == 'e' ||
               c == 'i' ||
               c == 'o' ||
               c == 'u'){
                     pre++;
               }else{
                pre--;
               }
               int rem = (i + 1)%period;

               long[]count = map.computeIfAbsent(pre,x->new long[period]);
               ans+=count[rem];
               count[rem]++;
     }
     return ans;
    }
}