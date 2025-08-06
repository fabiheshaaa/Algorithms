import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskg {
    static int Idx = 0;
    static int[] temp; 
    static StringBuilder sb = new StringBuilder();
    
    static void postOrder(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return;
        int root = preorder[Idx++];
        int rootIndex = temp[root];     
        postOrder(inorder, preorder, inStart, rootIndex - 1);
        postOrder(inorder, preorder, rootIndex + 1, inEnd);     
        sb.append(root).append(" ");
    }
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] inorder = new int[len];
        int[] preorder = new int[len];
        temp = new int[len + 1]; 
        String[] in = br.readLine().split(" ");
        String[] pre = br.readLine().split(" ");
        for (int i = 0; i < len; i++) {
            inorder[i] = Integer.parseInt(in[i]);
            temp[inorder[i]] = i; 
            preorder[i] = Integer.parseInt(pre[i]);
        }
        postOrder(inorder, preorder,0, len - 1);  
        System.out.println(sb.toString().trim());
    }
}