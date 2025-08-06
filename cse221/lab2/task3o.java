import java.io.*;
import java.util.*;

public class task3o {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);

        String[] nums = br.readLine().split(" ");

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(nums[i]);
            arr[i][1] = i + 1; 
        }

       
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i][0] + arr[left][0] + arr[right][0];

                if (sum == x) {
                    System.out.println(arr[i][1] + " " + arr[left][1] + " " + arr[right][1]);
                    return;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(-1);
    }
}