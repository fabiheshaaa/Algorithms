import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
     public static void main(String []arg) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int len= Integer.parseInt(br.readLine());
        String []inputarr2= br.readLine().split(" ");

        

        int []arr1= new int[len];
        int[] temp =new int[len];
        for (int i=0; i<len; i++){
            arr1[i]= Integer.parseInt(inputarr2[i]);
        }
        Long invCount= mergeSort(arr1, temp, 0, len- 1);
         System.out.println(invCount);
         

    }
     public static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        long invCount = 0;

        int i = left;   
        int j = mid + 1; 
        int k = left;     
        
        for (int n = left; n <= mid; n++) {
            while (j <= right && (long) arr[n] > (long) arr[j] * arr[j]) {
                j++;
            }
            invCount += (j - (mid + 1));
        }
       
           
        j=mid+1;
         while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {

                temp[k++] = arr[j++];
               
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
       

        return invCount;
    }

 
    public static long mergeSort(int[] arr, int[] temp, int left, int right) {
        
        long invCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);         
            invCount += mergeSort(arr, temp, mid + 1, right);   
            invCount += merge(arr, temp, left, mid, right);     
        }

        return invCount;
    }
}