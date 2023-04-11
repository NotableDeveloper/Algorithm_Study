package Chap07;

public class Chap07_03 {
    public static int solution(int n){
        if(n == 1) return 1;

        else{
            return n * solution(n - 1);
        }
    }
}
