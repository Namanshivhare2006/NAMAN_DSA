class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int firsthalf = 0;
        int secondhalf = 0;
        for(int i = 0; i<n/2; i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='i' || ch=='e' || ch=='o' || ch=='u' || ch=='A' || ch=='I' || ch=='E' || ch=='O' || ch=='U'){
                firsthalf++;
            }
        }
        for(int i = n/2; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='i' || ch=='e' || ch=='o' || ch=='u' || ch=='A' || ch=='I' || ch=='E' || ch=='O' || ch=='U'){
                secondhalf++;
            }
        }
return firsthalf==secondhalf;
        
    }
}