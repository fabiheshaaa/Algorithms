import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int vertices = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        int source = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int[] u = new int[edges];
        int[] v = new int[edges];
        int[] w = new int[edges];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < edges; i++) u[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < edges; i++) v[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < edges; i++) w[i] = Integer.parseInt(st.nextToken());

        // initialize graph with safe 1-based indexing
        ArrayList<int[]>[] graph = new ArrayList[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int from = u[i];
            int to = v[i];
            int weight = w[i];
            if (from >= 1 && from <= vertices && to >= 1 && to <= vertices) {
                graph[from].add(new int[]{to, weight});
            }
        }

        // Dijkstra
        long[] dist = new long[vertices + 1];
        int[] parent = new int[vertices + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[source] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, source});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int uNode = (int) cur[1];
            if (d > dist[uNode]) continue;

            for (int[] e : graph[uNode]) {
                int vNode = e[0];
                int wght = e[1];
                if (dist[vNode] > d + wght) {
                    dist[vNode] = d + wght;
                    parent[vNode] = uNode;
                    pq.add(new long[]{dist[vNode], vNode});
                }
            }
        }

        if (dist[destination] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        // Reconstruct path
        int[] path = new int[vertices + 1];
        int len = 0;
        for (int cur = destination; cur != -1; cur = parent[cur]) {
            path[len++] = cur;
        }

        System.out.println(dist[destination]);
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(path[i]);
            if (i > 0) System.out.print(" ");
        }
        System.out.println();
    }
}
