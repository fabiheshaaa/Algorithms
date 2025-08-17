import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class cycledetector {
    
static ArrayList<Integer>[] neighbours;
static int [] check;
static boolean hasCycle=false;
 public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1= br.readLine().split(" ");
        int M= Integer.parseInt(line1[0]);
        int N= Integer.parseInt(line1[1]);
        
        neighbours= new ArrayList[M+1];
        for( int i=0; i<=M; i++){
            neighbours[i]= new ArrayList<>();
        }

        for( int i=0;i<N; i++){
            String[] input= br.readLine().split(" ");
            int from= Integer.parseInt(input[0]);
            int to= Integer.parseInt(input[1]);
            neighbours[from].add(to);
        }
        check = new int[M+1];

        for (int i = 1; i <=M; i++) {
            if (check[i] == 0) {
                dfsCycle(i);
                if (hasCycle) break;
            }
        }

        System.out.println(hasCycle ? "YES" : "NO");
    }
    static void dfsCycle(int x){
        check[x]=1;
        for(int y: neighbours[x]){
            if(check[y]==0){
                dfsCycle(y);
                if (hasCycle) return;
            }    
            else if(check[y]==1){
                hasCycle=true;
                return;
            }
        }
        check[x]=2;
    }

   
}
