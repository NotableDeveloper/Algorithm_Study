package Inflearn.Basic.Chap02;

import java.util.ArrayList;

public class Chap02_03 {
    public static String[] solution(int n, int[] log_A, int[] log_B){
        ArrayList<String> answer = new ArrayList();

        for(int i = 0; i < n; i++){
            if(log_A[i] == log_B[i])
                answer.add("D");

            else if((log_A[i] + 2) % 3 == log_B[i])
                answer.add("A");

            else answer.add("B");
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int[] log_A = {2, 3, 3, 1, 3};
        int[] log_B = {1, 1, 2, 2, 3};

        for(String result : solution(5, log_A, log_B)){
            System.out.println(result);
        }
    }
}
