package Inflearn.Basic.Chap02;

public class Chap02_05 {
    public static int solution(int n){
        int count = 0;
        boolean[] check = new boolean[n + 1];

        for(int i = 2; i <= n; i++){
            if(!check[i]){
                count++;

                for(int j = i; j <= n; j = j + i)
                    check[j] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(20));
    }
}
