import java.io.*;
import java.util.*;

public class SecondShortestPath {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w}); // bidirectional
        }

        long[] dist1 = new long[N + 1];
        long[] dist2 = new long[N + 1];
        Arrays.fill(dist1, Long.MAX_VALUE);
        Arrays.fill(dist2, Long.MAX_VALUE);
        dist1[S] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, S});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                long newDist = d + w;

                if (newDist < dist1[v]) {
                    dist2[v] = dist1[v];
                    dist1[v] = newDist;
                    pq.add(new long[]{dist1[v], v});
                } else if (newDist > dist1[v] && newDist < dist2[v]) {
                    dist2[v] = newDist;
                    pq.add(new long[]{dist2[v], v});
                }
            }
        }

        if (dist2[D] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist2[D]);
    }
}
