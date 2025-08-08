import java.io.*;
import java.util.*;
public class AdjList {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []input=br.readLine().split(" ");
        int nodes= Integer.parseInt(input[0]);
        int edges= Integer.parseInt(input[1]);
        
        String [] source = br.readLine().split(" ");
        String [] des = br.readLine().split(" ");
        String [] weight = br.readLine().split(" ");

        HashMap< String, List<String>> adjList = new HashMap<>();
          
        for(int i=0;i<edges;i++){
            adjList.putIfAbsent(source[i],new ArrayList<>());
            adjList.get(source[i]).add("("+des[i]+","+weight[i]+")");
        }
         for(int j=1; j<=nodes;j++){
            String key = String.valueOf(j);           
            System.out.print(j+":");
            List<String> edgeList= adjList.get(key);

            if(edgeList!=null){
                for(String edge: edgeList){
                    System.out.print(" "+edge);
                }
            }
            System.out.println();
        }
    }
}
