import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int postIndex;
    static int[] posMap;
    static StringBuilder sb = new StringBuilder();

    static void buildPreOrder(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return;

        int rootVal = postorder[postIndex--];
        sb.append(rootVal).append(" ");

        int rootIdx = posMap[rootVal];

        buildPreOrder(inorder, postorder, rootIdx + 1, inEnd);
        buildPreOrder(inorder, postorder, inStart, rootIdx - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] inorder = new int[N];
        int[] postorder = new int[N];
        posMap = new int[N + 1];

        String[] inStr = br.readLine().split(" ");
        String[] postStr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(inStr[i]);
            posMap[inorder[i]] = i;
        }

        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(postStr[i]);
        }

        postIndex = N - 1;
        buildPreOrder(inorder, postorder, 0, N - 1);
        System.out.println(sb.toString().trim());
    }
}
