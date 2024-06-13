package Other.dp;

public class GoldMine {
    // 오른쪽 위, 오른쪽, 오른쪽 아래
    public static int[] dx = {-1, 0, 1};
    public static int[][] dp;

    public static int solution(int n, int m, int[][] goldmine){
        int answer = 0;
        dp = new int[n][m];

        // DP 테이블 초기화
        for(int i = 0; i < n; i++){
            dp[i] = goldmine[i];
        }

        // 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 금광 탐색
        for(int y = 1; y < m; y++){
            for(int x = 0; x < n; x++){
                int max = 0;

                for(int next : dx){
                    int nx = x + next;

                    if(nx >= 0 && nx < n){
                        max = Math.max(max, dp[nx][y - 1]);
                    }
                }

                dp[x][y] = max + goldmine[x][y];
            }
        }

        // 금광의 가장 끝에서 큰 값 찾기
        for(int i = 0; i < n; i++){
            answer = Math.max(answer, dp[i][m - 1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] golomine = {{1, 3, 3, 2}, {2, 1, 4, 1}, {0, 6, 4, 7}};
        System.out.println(solution(3, 4, golomine));
    }
}
