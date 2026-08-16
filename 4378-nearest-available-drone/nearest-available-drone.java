class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
     int dx = target[0];
     int dy = target[1];
     int idx = -1;

     int min = Integer.MAX_VALUE;
     for(int i = 0; i<drones.length; i++){
        int x = drones[i][0];
        int y = drones[i][1];
        int r = drones[i][2];
        int dist = Math.abs(x - dx) + Math.abs(y - dy);
        if(dist<=r && dist < min){
            min = dist;
            idx = i;

        }
     }   
     return idx;
    }
}