import java.io.*;
import java.util.*;

public class AliceBobMeet {

    static long[] dijkstra(int N, ArrayList<int[]>[] graph, int start) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        long[] distAlice = dijkstra(N, graph, S);
        long[] distBob = dijkstra(N, graph, T);

        long minTime = Long.MAX_VALUE;
        int meetNode = -1;
        for (int i = 1; i <= N; i++) {
            if (distAlice[i] == Long.MAX_VALUE || distBob[i] == Long.MAX_VALUE) continue;
            long meetTime = Math.max(distAlice[i], distBob[i]);
            if (meetTime < minTime || (meetTime == minTime && i < meetNode)) {
                minTime = meetTime;
                meetNode = i;
            }
        }

        if (meetNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(minTime + " " + meetNode);
        }
    }
}
