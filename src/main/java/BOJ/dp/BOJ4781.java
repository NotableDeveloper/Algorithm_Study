package BOJ.dp;

import java.util.Scanner;

public class BOJ4781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            int m = (int) Math.round(sc.nextDouble() * 100);

            if(n == 0 && m == 0) break;

            int[] DP = new int[m + 1];

            for(int i = 0; i < n; i++){
                int cal = sc.nextInt();
                int price = (int) Math.round(sc.nextDouble() * 100);

                for(int j = price; j <= m; j++){
                    DP[j] = Math.max(DP[j], DP[j - price] + cal);
                }
            }

            System.out.println(DP[m]);
        }
    }
}
