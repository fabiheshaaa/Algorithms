import java.io.*;
import java.util.*;

public class BeautifulPath {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[] weight = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[S] = weight[S];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{dist[S], S});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];

            if (cost > dist[u]) continue;

            for (int v : graph[u]) {
                long newCost = dist[u] + weight[v];
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }

        if (dist[D] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist[D]);
    }
}
