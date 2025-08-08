import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class knightMove {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N= Integer.parseInt(firstLine[0]);
        int M= Integer.parseInt(firstLine[1]);
        int K= Integer.parseInt(firstLine[2]);

       Set <String> knightSet = new HashSet<>();
        int[][] knights= new int[K][2];

        for (int i= 0; i<K; i++) {
            String[] input = br.readLine().split(" ");
            int x= Integer.parseInt(input[0]);
            int y= Integer.parseInt(input[1]);
            knights[i][0]= x;
            knights[i][1]= y;
            knightSet.add(x + "," + y);
        }

        int [] xdif={2,2,-2,-2,1,1,-1,-1};
         int [] ydif={1,-1,1,-1,2,-2,2,-2};

        for (int i = 0; i < K; i++) {
            int x= knights[i][0];
            int y= knights[i][1];

            for (int k=0; k<8; k++) {
                int nx=x + xdif[k];
                int ny=y + ydif[k];
                
                    if (knightSet.contains(nx + "," + ny)) {
                        System.out.println("YES");
                        return;
                    }
                
            }
        }

        System.out.println("NO");
    }
}