package Chap02;

public class Chap02_02 {
    public static int solution(int n, int[] students){
        int answer = 1, max = students[0];

        for(int i = 1; i < n; i++){
            if(students[i] > max){
                max = students[i];
                answer++;
            }
        }

        return answer;
    }
}
