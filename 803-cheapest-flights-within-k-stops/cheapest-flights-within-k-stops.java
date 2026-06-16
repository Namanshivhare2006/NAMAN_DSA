class Solution {
    static class Pair{
        int node;
        int cost;
        int stops;
        Pair(int node,int cost,int stops){
             this.node = node;
             this.cost = cost;
             this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());

        }
        for(int[] f : flights){
            graph.get(f[0]).add(new int[]{f[1],f[2]});
        }
        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,0,0));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            int node = cur.node;
            int cost = cur.cost;
            int stops = cur.stops;
            if(stops>k){
                continue;
            }
            for(int []neb : graph.get(node)){
                int next = neb[0];
                int price = neb[1];
                int newcost = cost + price;

                if(newcost<dist[next]){
                    dist[next] = newcost;
                    q.offer(new Pair(next,newcost,stops+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}