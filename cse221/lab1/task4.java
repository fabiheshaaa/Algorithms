import java.io.*;
public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int inptnums= Integer.parseInt(br.readLine());
        for (int i=0; i<inptnums;i++) {
            int arrlen= Integer.parseInt(br.readLine());
            String arr1[]= new String[arrlen];
            int intArray[]=new int[arrlen];
            String arrinpt=br.readLine();
            arr1=arrinpt.split(" ");
             for (int j = 0; j < arrlen; j++) {
                try {
                    intArray[j] = Integer.parseInt(arr1[j]);
                } catch (NumberFormatException e) {
                    intArray[j] = 0; 
                }} 
             boolean sorted = true;
            for (int k = 0; k < arrlen- 1; k++) {
                if (intArray[k] > intArray[k + 1]) {
                    sorted = false;
                    break;
                }}
             System.out.println(sorted ? "YES" : "NO");
}
    }}