import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Matrix {
      public static void main(String[] args)throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int test=Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<test;i++){
            String []inp1=br.readLine().split(" ");
            long[][] matrix={
               {Long.parseLong(inp1[0]), Long.parseLong(inp1[1])},
               {Long.parseLong(inp1[2]), Long.parseLong(inp1[3])}
            };
            long m=Long.parseLong(br.readLine());
            long[][] ans=fastMod(matrix,m);

            sb.append(ans[0][0]).append(" ").append(ans[0][1]).append("\n");
            sb.append(ans[1][0]).append(" ").append(ans[1][1]).append("\n");
            
        }
        System.out.print(sb);

        
    }
    

       public static long [][]fastMod(long[][] matrix,long m){
      long [][]res={
        {1,0},
        {0,1}
      };
      while (m>0){
          if(m%2!=0){
            res=mult(res,matrix);
          }
          matrix=mult(matrix,matrix);
          m/=2;
       }
       return res;

    }
    public static long[][] mult(long[][] A,long [][]B){
      long mod=1000000007;  
      long [][] c=new long[2][2];
        c[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0]) % mod;
         c[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1]) % mod;
        c[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0]) % mod;
        c[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1]) % mod;
       
        return c;
        
    }
    
 
}
