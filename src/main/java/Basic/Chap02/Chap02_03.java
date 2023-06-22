package Basic.Chap02;

import java.util.ArrayList;

public class Chap02_03 {
    public static String[] solution(int n, int[] log_A, int[] log_B){
        ArrayList<String> answer = new ArrayList();

        for(int i = 0; i < n; i++){
            int result = log_A[i] - log_B[i];

            switch (result){
                case -1 : answer.add("B"); break;
                case -2 : answer.add("A"); break;
                case 0 : answer.add("D"); break;
                case 1 : answer.add("A"); break;
                case 2 : answer.add("B"); break;
                default: break;
            }
        }

        return answer.toArray(new String[0]);
    }
}
