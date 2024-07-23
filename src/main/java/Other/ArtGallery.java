package Other;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 예술품 종류, 최소 비용, 최대 비용 입력받기
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 예술품 가격 입력받기
        long[] prices = new long[N + 1];
        for(int i = 1; i <= N; i++)
            prices[i] = Integer.parseInt(st.nextToken());

        // 첫 번째 예술품부터 N번째 예술품까지의 누적합 구하기
        long[] prefix = new long[N + 1];

        for(int i = 1; i <= N; i++)
            prefix[i] = prefix[i - 1] + prices[i];

        for(int start = 0; start < N; start++){
            for(int end = start + 1; end <= N; end++){
                long sum = prefix[end] - prefix[start];

                if(sum >= L && sum <= R){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}