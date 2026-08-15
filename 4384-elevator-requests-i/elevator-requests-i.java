class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int time = 0;
        int currentF = 0;
         

        for(int i = 0; i<requests.length; i++){
            
            time+= Math.abs(currentF - requests[i]);
            currentF = requests[i];


        }
           return time;       
    }
}