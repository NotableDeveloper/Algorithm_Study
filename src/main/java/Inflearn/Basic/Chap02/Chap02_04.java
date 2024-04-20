package Inflearn.Basic.Chap02;

import java.util.ArrayList;

public class Chap02_04 {
    public static int[] solution(int n){
        int[] answer = new int[n];
        answer[0] = answer[1] = 1;

        for(int i = 2; i < n; i++){
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }


    public static void main(String[] args) {
        for(int i : solution(45)){
            System.out.print(i + " ");
        }
    }
}
