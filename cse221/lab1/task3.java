import java.io.*;
public class task3 {
    public static void main(String[] args)throws IOException {
        InputStreamReader ir= new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ir);
             
        int inptnum= Integer.parseInt(br.readLine());
            
        for (int i=0; i<inptnum;i++){     
            long sum=Long.parseLong(br.readLine());   
             System.out.println((sum*(sum+1))/2);}
          
        }
    }
       
    

