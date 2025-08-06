import java.io.*;
import java.util.*;

public class taskf {
    static int[] arr;
    static int[] temp;
     static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fillOrder(0, N - 1);

        StringBuilder sb = new StringBuilder();
        for(int num : temp) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void fillOrder(int left, int right) {
        if (left > right) return;

        int mid = (left + right) / 2;
        temp[index++] = arr[mid];
        fillOrder(left, mid - 1);
        fillOrder(mid + 1, right);
    }
}
