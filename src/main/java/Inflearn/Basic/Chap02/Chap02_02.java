package Inflearn.Basic.Chap02;

public class Chap02_02 {
    public static int solution(int n, int[] students){
        /*
            가장 앞에 있는 학생은 무조건 보일 수 밖에 없는 것을
            고려한다.
        */
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
