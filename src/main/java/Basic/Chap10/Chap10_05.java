package Basic.Chap10;

import java.util.Arrays;

public class Chap10_05 {

    // 1원부터 money원까지 최소 몇 개의 동전을 사용해야 하는 지를 기록한다.
    static int[] DP;

    public static int solution(int n, int[] coin, int money){
        DP = new int[money + 1];
        // 각 인덱스 별로 최소 값을 담아야하므로, 모든 배열의 값에 최대 값을 담아둔다.
        Arrays.fill(DP, Integer.MAX_VALUE);
        // 0원은 어떤 동전을 넣어도 만들 수 없으므로 0으로 초기화한다.
        DP[0] = 0;

        /*
            사용할 수 있는 모든 동전을 순차적으로 사용하여 1원부터 money원까지
            최소 몇 개의 동전이 필요한 지를 기록한다.
        */
        for(int c : coin){
            // 현재 사용하려는 동전의 금액부터 money원까지 사용할 수 있는 최소 동전의 갯수를 기록한다.
            for(int i = c; i <= money; i++){
                DP[i] = Math.min(DP[i], DP[i - c] + 1);
            }
        }

        return DP[money];
    }
}
