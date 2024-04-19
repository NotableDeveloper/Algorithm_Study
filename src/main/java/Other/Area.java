package Other;

import java.util.ArrayList;
import java.util.Collections;

/*
    2차원 배열 내의 영역 넓이 구하기
*/
public class Area {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int[][] check;
    static int area_size = 1;

    public static ArrayList<Integer> solution(int N, int[][] map) {
        ArrayList<Integer> answer = new ArrayList<>();
        check = new int[N][N];

        // 전체 블록을 대상으로 탐색
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    DFS(N, map, i, j);
                    answer.add(area_size);
                    area_size = 1;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    private static void DFS(int N, int[][] map, int x, int y) {
        check[x][y] = 1;
        map[x][y] = 0;

        // 현재 위치인 (X, Y)에서 상, 하, 좌, 우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나는 경우
            if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            // 이미 방문한 곳인 경우
            if(check[nx][ny] == 1)
                continue;

            // 벽을 만나는 경우
            if(map[nx][ny] == 0) {
                check[nx][ny] = 1;
                continue;
            }

            // 다음 칸을 탐색
            DFS(N, map, nx, ny);
            area_size++;
        }
    }

    public static void main(String[] args) {
        int N = 6;

        int[][] map = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0}
        };

        System.out.println(solution(N, map));
    }
}
