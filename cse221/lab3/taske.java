import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taske {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int inputnum= Integer.parseInt(br.readLine());
        
        for( int i = 0; i < inputnum; i++ ){
            String []inputString = br.readLine().split(" ");

            int len=inputString.length;
            

            int base = Integer.parseInt(inputString[0]);
            int expo = Integer.parseInt(inputString[1]);
            int mod = Integer.parseInt(inputString[2]);

            int result=0;
            if(base ==1){
                result= expo%mod;
               
            }
                
            else{
                long numerator = modPow(base, expo + 1, mod * (base - 1)) - 1;
                if (numerator < 0) numerator += (long) mod * (base - 1);

                long denominator = base - 1;
                long modInv = modInverse(denominator, mod); 

                result = (int) ((numerator % (mod * (base - 1)) * modInv) % mod);
            }

            System.out.println(result);
            }            
        }
    }
     static long modPow(long base, long exp, long mod) {
    long result = 1;
    base = base % mod;

    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        exp= exp/2;
    }
    return result;
}
  static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

