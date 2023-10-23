package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14501 {
    static int[] schedule;
    static int[] pay;
    static int[] DP;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        schedule = new int[n + 1];
        pay = new int[n + 1];
        DP = new int[n + 1];

        for(int i = 1; i <= n; i++){
            String[] line = br.readLine().split(" ");
            schedule[i] = Integer.parseInt(line[0]);
            pay[i] = Integer.parseInt(line[1]);
        }

        solution(n);
    }

    public static void solution(int n){
        int max_pay = 0;

        for(int i = 0; i <= n; i++){
            DP[i] = Math.max(max_pay, DP[i]);

            if(schedule[i] + i <= n){
                DP[schedule[i] + i] = Math.max(DP[schedule[i] + i], pay[i] + DP[i]);
            }

            max_pay = Math.max(max_pay, DP[i]);
        }

        System.out.println(max_pay);
    }
}
