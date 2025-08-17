import java.util.*;
import java.io.*;
public class BfsTraversal{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] input1= br.readLine().split(" ");

        int cities= Integer.parseInt(input1[0]);
        int roads= Integer.parseInt(input1[1]);

         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= cities; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads; i++) {
            String []input= br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        for (int i = 1; i <= cities; i++) {
          Collections.sort(graph.get(i));
    }
         boolean[] visited = new boolean[cities+ 1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();

        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int neighbor : graph.get(node) ) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }

        }
         for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}