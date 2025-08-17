import java.util.*;
import java.io.*;

public class ShortestLexicographicPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        
        int N= Integer.parseInt(input1[0]); 
        int M= Integer.parseInt(input1[1]); 
        int S= Integer.parseInt(input1[2]); 
        int D= Integer.parseInt(input1[3]); 
        
        int[] u= new int[M];
        int[] v= new int[M];
        
        String[] line2= br.readLine().split(" ");
        String[] line3= br.readLine().split(" ");
        
        for (int i= 0; i<M; i++) {
            u[i]= Integer.parseInt(line2[i]);
            v[i]= Integer.parseInt(line3[i]);
        }
        
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i= 0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
         for (int i = 0; i < M; i++) {
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
        }
         for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        
         boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        visited[S] = true;
        queue.add(S);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }
            
        if (!visited[D]) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> path = new ArrayList<>();
        for (int a= D; a!= -1; a= parent[a]) {
            path.add(a);
        }
        Collections.reverse(path);
        
       
        System.out.println(path.size() - 1); 
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}        