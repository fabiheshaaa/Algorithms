import java.io.*;
import java.util.*;

public class EdgeQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int vertices = Integer.parseInt(firstLine[0]);
        int edges = Integer.parseInt(firstLine[1]);

        HashMap<Integer, Integer> degreeDifference = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            degreeDifference.put(i, 0);
        }
        
        String[] fromVert = reader.readLine().split(" ");
        for (int i = 0; i < edges; i++) {
            int from = Integer.parseInt(fromVert[i]);
            degreeDifference.put(from, degreeDifference.get(from) - 1);
        }

        String[] toVert = reader.readLine().split(" ");
        for (int i = 0; i < edges; i++) {
            int to = Integer.parseInt(toVert[i]);
            degreeDifference.put(to, degreeDifference.get(to) + 1);
        }
        
        for (int i=1; i<=vertices; i++) {
            System.out.print(degreeDifference.get(i) + " ");
        }
    }
}