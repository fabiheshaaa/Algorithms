import java.io.*;
import java.util.*;

public class MinimizeDanger {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        long[] danger = new long[N + 1];
        Arrays.fill(danger, Long.MAX_VALUE);
        danger[1] = 0; // danger of city 1 is 0

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long curDanger = cur[0];
            int u = (int) cur[1];

            if (curDanger > danger[u]) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];
                long newDanger = Math.max(danger[u], w);
                if (newDanger < danger[v]) {
                    danger[v] = newDanger;
                    pq.add(new long[]{newDanger, v});
                }
            }
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (danger[i] == Long.MAX_VALUE) sb.append("-1 ");
            else sb.append(danger[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
