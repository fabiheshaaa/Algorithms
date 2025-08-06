import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int len = Integer.parseInt(firstLine[0]);
        int val= Integer.parseInt(firstLine[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] frequency= new int[len+1];
        
        int right=0;
        int left=0;
        int distinct=0;
        int max=0;

        while(right<len){
            if(frequency[arr[right]]==0) distinct++;
            frequency[arr[right]]++;

            while(distinct>val){
                frequency[arr[left]]--;
                if(frequency[arr[left]]==0)distinct--;

                left++;
            }

            right++;
            if(max<((right-left))) {
                max=(right-left);
            }
        }
        System.out.println(max);
    }
}


  
