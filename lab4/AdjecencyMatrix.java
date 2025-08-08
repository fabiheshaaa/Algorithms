import java.io.*;

public class AdjecencyMatrix {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []input= br.readLine().split(" ");

        int n= Integer.parseInt(input[0]);
        int m= Integer.parseInt(input[1]);

        int [][] adjmatrix= new int[n][n];

        for(int i=0; i<m; i++){
            String[] edge= br.readLine().split(" ");
            int s=Integer.parseInt(edge[0])-1;
            int d=Integer.parseInt(edge[1])-1;
            
            adjmatrix [s][d]= Integer.parseInt(edge[2]);
        }
        for (int i=0; i<n; i++){
             for (int j=0;j<n;j++) {
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }
  
        }
    }    

