import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GraphMetamorphosis {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int vertices= Integer.parseInt(br.readLine());

        int [][] adjMatrix= new int[vertices][vertices];

        for(int i=0; i<vertices; i++){
               String [] data= br.readLine().split(" ");
            for(int k=1;k<=Integer.parseInt(data[0]);k++){
               int j=Integer.parseInt(data[k]);
               adjMatrix[i][j]=1;
            }
        }
        for (int i=0;i<vertices;i++) {
         for (int j=0;j<vertices;j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
        }
    
