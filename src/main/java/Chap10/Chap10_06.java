package Chap10;

import java.util.ArrayList;

public class Chap10_06 {
    /*
        0 ~ m 까지의 시간을 소요하면 최대 몇 점을 얻을 수 있는 지를 기록한다.
        DP[3] -> 3분을 소요하면 최대 몇 점을 얻을 수 있음.
     */
    static int[] DP;

    public static int solution(int m, ArrayList<Problem> problems){
        DP = new int[m + 1];

        for(Problem p : problems){
            // 주어진 시간부터 시작하여 문제의 제한시간까지 역순으로 기록한다.
            for(int i = m; i >= p.time; i--){
                DP[i] = Math.max(DP[i], DP[i - p.time] + p.score);
            }
        }

        return DP[m];
    }
}
