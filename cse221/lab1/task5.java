import java.io.*;
public class task5 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int arrlen= Integer.parseInt(br.readLine());
        String []arr1= new String [arrlen];
        String inputs= br.readLine();
        arr1=inputs.split(" ");
        int []arr2=new int[arrlen];
        for (int i =0; i<arrlen;i++){
            try{
                arr2[i]= Integer.parseInt(arr1[i]);
            }
            catch(NumberFormatException e){
                arr2[i]=0;
            }
        }
         boolean swapped;
        do {
            swapped = false;
        for (int j=0; j< arrlen-1; j++){
            if(arr2[j]%2==arr2[j+1]%2 && arr2[j]>arr2[j+1]){
                int temp= arr2[j];
                arr2[j]=arr2[j+1];
                arr2[j+1]=temp;
                swapped=true;
            }
        }
        }while (swapped); 

        for(int k =0; k<arrlen;k++){
            System.out.print(arr2[k] +" ");
        }

    }
}
