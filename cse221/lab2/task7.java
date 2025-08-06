import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task7 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int len = Integer.parseInt(firstLine[0]);
        int input= Integer.parseInt(firstLine[1]);
           
        String[] inputarr = br.readLine().split(" ");
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(inputarr[i]);
        }

        

        for( int i=0;i<input;i++){
            String []arr1= br.readLine().split(" ");
            
            int lowerbound=Integer.parseInt(arr1[0]);
            int upperbound=Integer.parseInt(arr1[1]);
             int left=0;
             int right=len;
            
            while(left<right){
                 int mid= left+right/2;
                if(arr[mid]<lowerbound){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            int strtidx=left;
            left=0;
            right=len;
            while(left<right){
                 int mid= left+right/2;
                if(arr[mid]<upperbound){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            int endidx=right;


                
            
             System.out.println(endidx-strtidx);
        }
       
    }
}
