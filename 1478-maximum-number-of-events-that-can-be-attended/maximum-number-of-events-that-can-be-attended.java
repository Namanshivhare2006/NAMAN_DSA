class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(i,j)->Integer.compare(i[0],j[0]));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int count = 0;
        int lastday = 0;
        int n  = events.length;
        int i = 0;
        for(int []event : events){
            lastday = Math.max(lastday,event[1]);
        }
        for(int day = 1; day<=lastday; day++){
            while(i<n && events[i][0] <= day){
                min.offer(events[i][1]);
                i++;
            }
             while (!min.isEmpty() && min.peek() < day) {
                min.poll();
            }
            if(!min.isEmpty()){
                min.poll();
                count++;
            }
            if(i==n && min.isEmpty()){
                break;
            }
        }
        return count;

        
    }
}