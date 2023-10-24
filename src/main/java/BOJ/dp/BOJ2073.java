package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int D = Integer.parseInt(line[0]);
        int P = Integer.parseInt(line[1]);
        int[] DP = new int[D + 1];

        for(int i = 0; i < P; i++){
            line = br.readLine().split(" ");
            int length =  Integer.parseInt(line[0]);
            int size = Integer.parseInt(line[1]);

            for(int j = D; j > length; j--){
                if(DP[j - length] == 0) continue;
                DP[j] = Math.max(DP[j], Math.min(DP[j - length], size));
            }

            DP[length] = Math.max(DP[length], size);
        }

        System.out.println(DP[D]);
    }
}
