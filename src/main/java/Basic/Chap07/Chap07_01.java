package Basic.Chap07;

public class Chap07_01 {
    public static void solution(int n) {
        if(n == 0) return;

        else{
            solution(n - 1);
            System.out.print(n + " ");
        }
    }
}
