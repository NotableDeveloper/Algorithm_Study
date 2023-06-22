package Basic.Chap07;

public class Chap07_02 {
    public static void solution(int n){
        if(n == 1){
            System.out.print(n);
        }

        else{
            solution(n / 2);
            System.out.print(n % 2);
        }
    }
}
