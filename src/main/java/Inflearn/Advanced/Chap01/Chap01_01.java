package Inflearn.Advanced.Chap01;

import java.util.Arrays;

public class Chap01_01 {
    public static char[] solutionWithSimulation(int n, int[][] ladder){
        /*
            index 번호를 1번으로 맞추기 위해 tempChars에서 시뮬레이션을 수행한 다음에
            answer에 정답을 복사하는 방식으로 문제를 해결.
         */
        char[] tempChars = new char[n + 1];
        char[] answer = new char[n];

        for(int i = 1; i < n + 1; i++){
            tempChars[i] = (char)(64 + i);
        }

        /*
            ladder의 세로 줄을 하나씩 탐색한다.
            탐색 과정에서 왼쪽 세로줄의 번호와 바로 오른쪽의 세로줄 번호를 Swap 한다.
        */
       for(int[] line : ladder){
           for(int x : line){
               char temp = tempChars[x];
               tempChars[x] = tempChars[x + 1];
               tempChars[x + 1] = temp;
           }
       }

       System.arraycopy(tempChars, 1, answer, 0, n);
       return answer;
    }
}
