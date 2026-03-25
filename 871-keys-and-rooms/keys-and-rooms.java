class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> sq = new LinkedList<>();
        vis[0] = true;
        sq.add(0);
        while(!sq.isEmpty()){
            int curr = sq.poll();
            for(int neb : rooms.get(curr)){
                if(!vis[neb]){
                sq.add(neb);
                vis[neb] = true;
                }
            }
        }
        for(boolean flag : vis){
            if(!flag) return false;
        }
        return true;
        
    }
}