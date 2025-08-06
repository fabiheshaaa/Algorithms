import java.io.*;
public class task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] firstline= br.readLine().split(" ");
        String[] secline=br.readLine().split(" ");
        int len=Integer.parseInt(firstline[0]);
        Long[] array= new Long[len];

        for(int i=0;i<len;i++){
            array[i]=Long.parseLong(secline[i]);           
        }

        int left=0;
        int right=len;
        int mid=(len/2);
        
        boolean found=false;
        Long val=Long.parseLong(firstline[1]);
        System.out.println(val);
        for(int i=0;i<mid;i++){
           for(int j=mid+1;j<len;j++){
            Long sum=array[i]+array[mid]+array[j];
            System.out.println(sum);
            if(sum==val){
                System.out.println(i+1+" "+(mid+1)+" "+(j+1));
                found=true;
                break;
            }
        }
    }
        if(found==false) System.out.println(-1);
    }
}
