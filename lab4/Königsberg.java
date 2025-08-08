import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Königsberg {
     public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input=br.readLine().split(" ");

        int vertices=Integer.parseInt(input[0]);
        int edges=Integer.parseInt(input[1]);
        
        String [] input2=br.readLine().split(" ");
        String [] input3=br.readLine().split(" ");
        
        int [] arr=new int [vertices];
        int [] source= new int [edges];
        int [] destination= new int [edges];

        for(int i=0;i<edges;i++){
            source[i]=Integer.parseInt(input2[i]);
            destination[i]=Integer.parseInt(input3[i]);

            arr[source[i]-1]+=1;
            arr[destination[i]-1]+=1;
        }

        int oddcount=0;
        for(int i=0; i<vertices;i++){
            if(arr[i]%2!=0) oddcount++;
        }
        if(oddcount==0 || oddcount==2)
          System.out.print("YES");
        else 
          System.out.print("NO");

    }
}
