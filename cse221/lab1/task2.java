import java.io.*;
public class task2 {
    public static void main(String[] args)throws IOException{
        InputStreamReader ir= new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(ir);
        int loopn= Integer.parseInt(br.readLine());
        for(int i=0; i< loopn;i++){
            String inpt= br.readLine();
            String arr1[]= inpt.split(" ");
            if(arr1[2].equals("*")) System.out.println(Float.parseFloat(arr1[1])*Float.parseFloat(arr1[3]));
            else if(arr1[2].equals("+")){
                System.out.println(Float.parseFloat(arr1[1])+Float.parseFloat(arr1[3]));
            }
            else if(arr1[2].equals("-")){
                System.out.println(Float.parseFloat(arr1[1])-Float.parseFloat(arr1[3]));
            }
            else{
                 System.out.println(Float.parseFloat(arr1[1])/Float.parseFloat(arr1[3]));
            }
        }
    }
}
