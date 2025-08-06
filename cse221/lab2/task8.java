import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class task8 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ipt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (ipt > 0) {
            String[] inpuStrings = br.readLine().split(" ");
            long term = Long.parseLong(inpuStrings[0]);
            long divident = Long.parseLong(inpuStrings[1]);

            long left = 1;
            long right = term* divident;
            while(left<right){
                long mid=(left+right)/2;
                long x= mid-(mid/divident);
                if(x<term){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            } 
            System.out.println(left);
            ipt--;
        }
     }
}
