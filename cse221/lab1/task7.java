import java.io.*;
public class task7{
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int arrlen=Integer.parseInt(br.readLine());
        String []id= new String[arrlen];
        String input1= br.readLine();
        id=input1.split(" ");
        String []num= new String[arrlen];
        String input2=br.readLine();
        num=input2.split(" ");
        int []id1= new int[arrlen];
        int []num1=new int[arrlen];
         for (int i =0; i<arrlen;i++){
           try{
             id1[i]= Integer.parseInt(id[i]);
             num1[i]=Integer.parseInt(num[i]);
           }
           catch(NumberFormatException e){
            id1[i]=0;
            num1[i]=0;
           }}
           int swapCount=0;

        for(int j=0;j<arrlen-1;j++){
             int best = j;
            for(int k=j+1; k<arrlen;k++){
                if(num1[best]<num1[k] || num1[best]==num1[k] && id1[best]>id1[k])
            {
                best=k;
            }
            }
              if (best != j) {
                
                int tempNum = num1[j];
                num1[j] = num1[best];
                num1[best] = tempNum;

               
                int tempId = id1[j];
                id1[j] = id1[best];
                id1[best] = tempId;

                swapCount++;
            }
        }

       
        System.out.println("Minimum swaps: "+swapCount);
        for (int i = 0; i < arrlen; i++) {
            System.out.println("ID: "+id1[i] + " Mark: " + num1[i]);
        }
    }
}
        