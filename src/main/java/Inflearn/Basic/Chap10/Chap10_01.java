package Inflearn.Basic.Chap10;

public class Chap10_01 {
    static int[] DP;
    public static int solution(int n){
        DP = new int[n + 1];
        DP[1] = 1;
        DP[2] = 2;

        for(int i = 3; i <= n; i++){
            DP[i] = DP[i - 2] + DP[i - 1];
        }

        return DP[n];
    }
}
