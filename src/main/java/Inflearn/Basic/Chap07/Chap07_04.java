package Inflearn.Basic.Chap07;

public class Chap07_04 {
    public static int[] fibo;

    public static int solution(int n){
        if(n == 1 || n == 2) return fibo[n] = 1;
        else if(fibo[n] > 0) return fibo[n];
        else return fibo[n] = solution(n - 2) + solution(n - 1);
    }
}
