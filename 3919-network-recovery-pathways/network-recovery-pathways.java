class Solution {

    int n;
    List<int[]>[] graph;
    long k;

    boolean check(int mid) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();

            long d = cur[0];
            int u = (int) cur[1];

            if (d > k)
                return false;

            if (u == n - 1)
                return true;

            if (d > dist[u])
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int w = edge[1];

                if (w < mid)
                    continue;

                long nd = d + w;

                if (nd < dist[v]) {

                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }

        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        this.k = k;
        n = online.length;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int w = e[2];

            if (!online[u] || !online[v])
                continue;

            graph[u].add(new int[]{v, w});

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        while (low < high) {

            int mid = (low + high + 1) / 2;

            if (check(mid))
                low = mid;
            else
                high = mid - 1;
        }

        return check(low) ? low : -1;
    }
}