import java.io.*;
public class sevenBridge {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inp=br.readLine().split(" ");
        int oddcount=0;
        int v=Integer.parseInt(inp[0]);
        int e=Integer.parseInt(inp[1]);
        
        String [] inp2=br.readLine().split(" ");
        String [] inp3=br.readLine().split(" ");
        
        int [] arr=new int [v];
        int [] src= new int [e];
        int [] des= new int [e];
        for(int i=0;i<e;i++){
            src[i]=Integer.parseInt(inp2[i]);
            des[i]=Integer.parseInt(inp3[i]);

            arr[src[i]-1]+=1;
            arr[des[i]-1]+=1;
        }

       
        for(int i=0; i<v;i++){
            if(arr[i]%2!=0) oddcount++;
        }
        if(oddcount==0 || oddcount==2)
          System.out.print("YES");
        else 
          System.out.print("NO");

    }
}