
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bt {

    static int preIndex = 0;
    static int[] pos;  

    static void postOrder(int[] inorder, int[] preord, int inStrt, int inEnd) {
        if (inStrt > inEnd) return;

        int rootVal = preord[preIndex++];
        int inIndex = pos[rootVal];  

        postOrder(inorder, preord, inStrt, inIndex - 1);       
        postOrder(inorder, preord, inIndex + 1, inEnd);       
        System.out.print(rootVal + " ");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inord = new int[N];
        int[] preord = new int[N];
        for (int i = 0; i < N; i++) inord[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) preord[i] = Integer.parseInt(br.readLine());
        pos = new int[N + 1];  
        for (int i = 0; i < N; i++) {
            pos[inord[i]] = i;
        }
        postOrder(inord, preord, 0, N - 1);
    }
}


