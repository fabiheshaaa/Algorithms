import java.io.*;
public class kingMove {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb= new StringBuilder();
       int n= Integer.parseInt(br.readLine());
       String []input=br.readLine().split(" ");

       int x=Integer.parseInt(input[0]);
       int y=Integer.parseInt(input[1]);
       int count=0;
       int[][] moves={
                   {x-1,y-1},
                   {x-1,y},
                   {x-1,y+1},
                   {x,y-1},
                   {x,y+1},
                   {x+1,y-1},
                   {x+1,y},
                   {x+1,y+1}
       };
       for(int i=0;i<8;i++){
         int a=moves[i][0];
         int b=moves[i][1];
         if(a>=1 && a<=n && b>=1 && b<=n){
            count++;
           sb.append(a+" "+b+"\n");
         }
       }
       System.out.println(count);
       System.out.print(sb);
   }
}