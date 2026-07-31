class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        Arrays.sort(time);
        long l = 1;
        long r = 1L*time[0]*totalTrips;
        while(l<r){
            long mid = l+ (r-l)/2;
            if(pos(time,totalTrips,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
        
    }
    public boolean pos(int []time, int totalTrips,long trips){
        long a = 0;
        for(int i = 0; i<time.length; i++){
            a+=trips/time[i];
        }
        return a>=totalTrips;
    }
}