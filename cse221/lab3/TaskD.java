  
  
  import java.io.*;
    import java.util.StringTokenizer;
  public class TaskD {
        static final long MOD = 1_000_000_007L;
    
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 20);
            BufferedOutputStream out = new BufferedOutputStream(System.out, 1 << 20);
            StringBuilder sb = new StringBuilder();
    
            int T = Integer.parseInt(br.readLine());
            long[][] cur = new long[2][2];
            long[][] res = new long[2][2];
            long[][] tmp = new long[2][2];
    
            while (T-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                cur[0][0] = Long.parseLong(st.nextToken());
                cur[0][1] = Long.parseLong(st.nextToken());
                cur[1][0] = Long.parseLong(st.nextToken());
                cur[1][1] = Long.parseLong(st.nextToken());
                long exp = Long.parseLong(br.readLine());
    
                
                res[0][0] = 1; res[0][1] = 0;
                res[1][0] = 0; res[1][1] = 1;
    
                
                while (exp > 0) {
                    if ((exp & 1) == 1) {
                        multiply(res, cur, tmp);
                        res = copy(tmp, res);
                    }
                    multiply(cur, cur, tmp);
                    cur = copy(tmp, cur);
                    exp >>= 1;
                }
    
                sb.append(res[0][0]).append(' ').append(res[0][1]).append('\n');
                sb.append(res[1][0]).append(' ').append(res[1][1]).append('\n');
            }
    
            out.write(sb.toString().getBytes());
            out.flush();
        }
    
        
        private static void multiply(long[][] A, long[][] B, long[][] tmp) {
            tmp[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0]) % MOD;
            tmp[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1]) % MOD;
            tmp[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0]) % MOD;
            tmp[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1]) % MOD;
        }
    
        
        private static long[][] copy(long[][] src, long[][] dst) {
            dst[0][0] = src[0][0];
            dst[0][1] = src[0][1];
            dst[1][0] = src[1][0];
            dst[1][1] = src[1][1];
            return dst;
        }
    }
}
