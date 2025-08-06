import java.io.*;
import java.util.*;

public class task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] copy = arr.clone();
        int[] sorted = arr.clone();
        
        
        if (sorted.length > 0) {
           
            int best= sorted[0];
            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i] > best) {
                    best = sorted[i];
                }
            }
            int[] count = new int[best + 1];
            
            for (int value : sorted) {
                count[value]++;
            }
            
            int idx = 0;
            for (int j = 0; j < count.length; j++) {
                while (count[j] > 0) {
                    sorted[idx] = j;
                    idx++;
                    count[j]--;
                }
            }
        }
        if (len == 1) {
            System.out.println("YES");
        } else if (len == 2) {
            if (arr[0] <= arr[1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int length = len;
            int iteration = 0;
            boolean sortable = false;
            while (iteration < 2 * length) {
                boolean c = false;
                int i = 0;
                while (i <= length - 3) {
                    if (arr[i] > arr[i + 1] || arr[i + 1] > arr[i + 2]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 2];
                        arr[i + 2] = temp;
                        c = true;
                    }
                    i++;
                }
                if (Arrays.equals(arr, sorted)) {
                    sortable = true;
                    break;
                }    
                if (!c) {
                    break;
                }
                iteration++;
            }
            if (sortable) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }
}