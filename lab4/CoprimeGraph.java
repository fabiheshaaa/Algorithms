import java.io.*;
import java.util.*;
public class CoprimeGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] input1= br.readLine().split(" ");
        int n= Integer.parseInt(input1[0]);
        int q= Integer.parseInt(input1[1]);

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        adjList.add(first);

        for (int i=1; i<=n; i++){
            ArrayList <Integer> tempArrayList= new ArrayList<>();
            for( int j=1; j<=n; j++){
                if(i!=j && gcd(i,j)==1){
                    tempArrayList.add(j);
                }
                else{
                    continue;
                }
            }
            Collections.sort(tempArrayList);
            adjList.add(tempArrayList);
        }

        for(int i=1; i<=q;i++){
            String [] input2= br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y= Integer.parseInt(input2[1]);

            ArrayList <Integer> temp= adjList.get(x);
            int len= temp.size();
            
            if(len>=y) System.out.println(temp.get(y-1));

            else{
                System.out.println(-1);
            }
        }
    }
     public static int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
