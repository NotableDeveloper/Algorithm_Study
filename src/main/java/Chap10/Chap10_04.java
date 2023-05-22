package Chap10;

import java.util.ArrayList;
import java.util.Collections;

public class Chap10_04 {
    /*
        벽돌 하나는 고유한 번호가 주어지므로, 번호에 해당하는 벽돌이 탑의 가장 상단에
        있을 때의 높이를 저장한다.
     */
    static int[] DP;

    /*
        벽돌의 넓이를 기준으로 내림차순으로 벽돌을 쌓는다. (가장 넓은 벽돌이 위로 가도록)
        벽돌을 쌓는 과정에서 다음에 쌓을 블록은 지금 쌓은 블록보다 무게가 가벼워야 한다.
     */
    public static int solution(int n, ArrayList<Brick> bricks){
        int answer;
        DP = new int[n];
        // 넓이 기준으로 내림차순 정렬한다.
        Collections.sort(bricks);
        DP[0] = bricks.get(0).height;
        answer = DP[0];

        // 첫번째 벽돌부터 마지막 벽돌까지 맨 위에 쌓았을 때의 높이를 구한다.
        for(int i = 0; i < n; i++){
            int max_h = 0;

            for(int j = i - 1; j >= 0; j--){
                /*
                    바로 앞의 벽돌이 더 좁고, DP 안에 바로 앞의 벽돌 높이가 현재 구한 최대 값보다 큰 경우에
                    바로 앞의 벽돌 높이 값을 갱신힌다.
                */
                if(bricks.get(j).weight > bricks.get(i).weight && DP[j] > max_h){
                    max_h = DP[j];
                }
            }
            DP[i] = max_h + bricks.get(i).height;
            answer = Math.max(answer, DP[i]);
        }

        return answer;
    }
}
