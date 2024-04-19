package Other;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class GameMapShortestPath {
    static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static int BFS(int[][] map) {
        /*
            새로운 map을 만들어서 탐색을 할 때마다 이동한 칸에
            현재까지 이동한 거리를 기록하고, 마지막 도착 지점에 기록된 거리를
            반환한다.
        */
        int[][] answer = new int[map.length][map[0].length];
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(0, 0));
        answer[0][0] = 1;

        while(!Q.isEmpty()) {
            Point current = Q.poll();

            for (int j = 0; j < 4; j++) {
                int nx = current.x + direction[j][0];
                int ny = current.y + direction[j][1];

                /*
                    다음 칸이 map을 벗어나는 지를 검사하고, 이동이 가능한 길인지와
                    새로운 map에 이동한 기록이 없으면 이동 기록을 남기고 다음 칸을 탐색한다.
                */
                if ((nx >= 0 && nx < map.length)
                        && (ny >= 0 && ny < map[0].length)
                        && (map[nx][ny] == 1 && answer[nx][ny] == 0)) {
                    answer[nx][ny] = answer[current.x][current.y] + 1;
                    Q.offer(new Point(nx, ny));
                }
            }
        }

        if(answer[map.length - 1][map[0].length - 1] == 0) return -1;
        else return answer[map.length - 1][map[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] case1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] case2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(BFS(case2));
    }
}
