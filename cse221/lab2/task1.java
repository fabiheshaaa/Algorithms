import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1 {
    public static void main(String []arg) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []inputArr= br.readLine().split(" ");
        String []inputarr2= br.readLine().split(" ");
        int len=Integer.parseInt(inputArr[0]);
        int [] intarray= new int[len];
        for(int i=0; i<len;i++){
            intarray[i]= Integer.parseInt(inputarr2[i]);
        }
        int left=0;
        int right=len-1;
        int val= Integer.parseInt(inputArr[1]);
        
        while(left<right){
            int sum=intarray[left]+intarray[right];
            if(sum>val){
                right--;
            }
            else if(sum<val){
                left++;
            }
            else if(sum==val){
                System.err.println(left+1+" "+(right+1));
                break;
            }
            else{
                System.out.println(-1);
                break;
            }
        }
    }
}
