package BOJ.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int maximum = Integer.MIN_VALUE;
    static int minimum = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;
    static int n;

    public static void DFS(int num, int idx) {
        if (idx == n) {
            maximum = Math.max(maximum, num);
            minimum = Math.min(minimum, num);
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {

                    case 0 : DFS(num + number[idx], idx + 1); break;
                    case 1 : DFS(num - number[idx], idx + 1); break;
                    case 2 : DFS(num * number[idx], idx + 1); break;
                    case 3 : DFS(num / number[idx], idx + 1); break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        DFS(number[0], 1);

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
