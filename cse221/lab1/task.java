import java.util.Scanner;
public class task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();  
            int sum = (N*(N+1))/2;
           
            System.out.println(sum);
        }
    }
}
