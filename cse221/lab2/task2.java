import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
    public static void main(String []arg) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String []inputArr= br.readLine().split(" ");
        String []inputarr2= br.readLine().split(" ");
        String []inputarr3=br.readLine().split(" ");
        int len1=Integer.parseInt(inputArr[0]);
        int len2=Integer.parseInt(inputArr[1]);
        Long[] intarray1= new Long[len1];
        Long [] intarray2=new Long[len2];
        for(int i=0; i<len1;i++){
            intarray1[i]= Long.parseLong(inputarr2[i]);
        }
        for(int i=0; i<len2;i++){
            intarray2[i]= Long.parseLong(inputarr3[i]);
        }
        int left=0;
        int right=len2-1;
        int val= Integer.parseInt(inputArr[2]);
        long minDiff = Long.MAX_VALUE;
        boolean found=false;
        int i=0;
        int j=0;
        while(left<len1 &&right>=0){
            Long sum=intarray1[left]+intarray2[right];
            Long diff=Math.abs(sum-val);
            
            if(diff<minDiff){
                minDiff=diff;
                i=left;
                j=right;
            }
            if(sum>val){
                right--;
            }
            else{
                left++;
            }
            
            }         
            System.out.println(i+1+" "+(j+1));  
        }
         
 }

