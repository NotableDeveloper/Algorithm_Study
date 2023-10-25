package Inflearn.Basic.Chap03;

public class Chap03_03 {
    public static int solution(int n, int k, int[] arr){
        int answer = 0, sum;

        for(int i = 0; i < k; i++){
            answer += arr[i];
        }

        sum = answer;

        for(int i = k; i < n; i++){
            sum += arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}