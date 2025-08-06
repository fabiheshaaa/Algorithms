import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class task5 {
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

        int right = 0;
        int left = 0;
        int sum = 0;
        int maxLen = 0;

        while(right<len){
            sum += arr[right];

            while (sum > val) {
                sum -= arr[left];
                left++;
            }
            if(maxLen<(right - left + 1)){
                 maxLen=right - left + 1;
                }
            right++;    
        }

        System.out.println(maxLen);
    }
}
