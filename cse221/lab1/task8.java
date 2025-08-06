import java.io.*;

public class tank8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ipt = Integer.parseInt(br.readLine());

        String[] trains = new String[ipt];
        String[] time = new String[ipt];
        int[] index = new int[ipt];
        String[] lines = new String[ipt];

        for (int i = 0; i < ipt; i++) {
            String Sinpt = br.readLine();
            lines[i] = Sinpt; // storing every lines
            String[] inpt = Sinpt.split(" ");
            trains[i] = inpt[0];
            time[i] = inpt[inpt.length - 1];
            index[i] = i; 
        }

        for (int j = 0; j < ipt - 1; j++) {
            int b = j;
            for (int k = j + 1; k < ipt; k++) {
                boolean shouldSwap = false;

                int cmpName = trains[b].compareTo(trains[k]);
                if (cmpName > 0) {
                    shouldSwap = true;
                } else if (cmpName == 0) {
                    int cmpTime = time[b].compareTo(time[k]);
                    if (cmpTime < 0) {
                        shouldSwap = true;
                    } else if (cmpTime == 0 && index[b] > index[k]) {
                        shouldSwap = true;
                    }
                }

                if (shouldSwap) {
                    b = k;
                }
            }

            if (b != j) {
                
                String tTrain = trains[j];
                trains[j] = trains[b];
                trains[b] = tTrain;

               
                String tTime = time[j];
                time[j] = time[b];
                time[b] = tTime;

                
                String tLine = lines[j];
                lines[j] = lines[b];
                lines[b] = tLine;

                
                int tIndex = index[j];
                index[j] = index[b];
                index[b] = tIndex;
            }
        }

        for (int i = 0; i < ipt; i++) {
            System.out.println(lines[i]);
        }
    }
}


