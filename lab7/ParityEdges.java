import java.io.*;
import java.util.*;

public class ParityEdges {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) w[i] = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            graph[u[i]].add(new int[]{v[i], w[i]});
        }

        // dist[node][parity] : min distance to node with last edge parity
        long[][] dist = new long[N + 1][2];
        for (int i = 0; i <= N; i++) Arrays.fill(dist[i], Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        // Start from node 1, no last parity (-1)
        // We push both possibilities from node 1 edges
        for (int[] edge : graph[1]) {
            int next = edge[0];
            int weight = edge[1];
            int parity = weight % 2;
            if (dist[next][parity] > weight) {
                dist[next][parity] = weight;
                pq.add(new long[]{weight, next, parity});
            }
        }

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int node = (int) cur[1];
            int lastParity = (int) cur[2];

            if (d > dist[node][lastParity]) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int weight = edge[1];
                int currParity = weight % 2;
                if (currParity != lastParity) {
                    long newDist = d + weight;
                    if (newDist < dist[next][currParity]) {
                        dist[next][currParity] = newDist;
                        pq.add(new long[]{newDist, next, currParity});
                    }
                }
            }
        }

        long ans = Math.min(dist[N][0], dist[N][1]);
        if (ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
