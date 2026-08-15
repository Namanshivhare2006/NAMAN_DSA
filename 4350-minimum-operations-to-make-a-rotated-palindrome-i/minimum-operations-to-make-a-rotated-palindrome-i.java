class Solution {
    public int minOperations(String s) {

        int ans=300000;
        int n=s.length();

        for(int i=0;i<s.length();i++){
            int cost=i;

            String dummy=s.substring(i)+s.substring(0,i);

            for(int j=0;j<s.length()/2;j++){
                char a1=dummy.charAt(j);
                char b1=dummy.charAt(n-1-j);

                int a=Math.abs(a1-b1);
                cost+=Math.min(a,26-a);
            }

            ans=Math.min(ans,cost);
        }

        return ans;
    }
}