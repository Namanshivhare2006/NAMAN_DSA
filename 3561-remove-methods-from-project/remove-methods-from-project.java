class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
     for(int i = 0; i<n; i++){
        graph.add(new ArrayList<>());
     }   
     int []indegree = new int[n];

     for(int[]edge : invocations){
        int u = edge[0];
        int v = edge[1];
        graph.get(u).add(v);
        indegree[v]++;
     }
     boolean[] suspicious = new boolean[n];
     dfs(k, graph,suspicious);
     int []outsideindegree = new int[n];

     for(int []edge : invocations){
        int u = edge[0];
        int v = edge[1];
        if(!suspicious[u] && suspicious[v]){
            outsideindegree[v]++;
        }
     }

     for(int i = 0; i<n; i++){
        if(suspicious[i] && outsideindegree[i] > 0){
            List<Integer> ans = new ArrayList<>();
            for(int j = 0; j<n; j++){
                ans.add(j);
            }
            return ans;
        }
     }
     List<Integer> ans = new ArrayList<>();
     for(int i = 0; i<n; i++){
        if(!suspicious[i]){
            ans.add(i);
        }
     }
     return ans;
    }
    public void dfs(int node, List<List<Integer>> graph, boolean[]suspicious){
        suspicious[node] = true;
        for(int next : graph.get(node)){
            if(!suspicious[next]){
                dfs(next,graph,suspicious);
            }
        }
    }
}