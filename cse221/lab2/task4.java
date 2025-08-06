import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int len1= Integer.parseInt(br.readLine());
        String []input1= br.readLine().split(" ");
        int len2=Integer.parseInt(br.readLine());
        String []input2= br.readLine().split(" ");
        int []arr1= new int[len1];
        int []arr2=new int[len2];

        for (int i=0;i<len1;i++){
            arr1[i]= Integer.parseInt(input1[i]);
        }
        for (int j=0;j<len2;j++){
            arr2[j]= Integer.parseInt(input2[j]);
        }
        int i=0;
        int j=0;
        int idx=0;

        int []arr3=new int[len1+len2];
        while(i<len1 && j<len2){
            if(arr1[i]<arr2[j]){
                arr3[idx++]=arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j]){
                arr3[idx++]=arr2[j];
                j++;
        }
            else{
                arr3[idx++]=arr2[j];
                arr3[idx++]=arr1[i];
                i++;
                j++;
            }
    }
    if(i<j){
        while(i<len1){
            arr3[idx++]=arr1[i];
            i++;
        }
    }else{
         while(j<len2){
            arr3[idx++]=arr2[j];
            j++;
        }
    }
    StringBuilder sb= new StringBuilder();
    for(int k=0;k<arr3.length;k++){
        sb.append(arr3[k]);
        if(i!=arr3.length-1){
            sb.append(" ");
        }
    }
    System.out.println(sb.toString());
}
}