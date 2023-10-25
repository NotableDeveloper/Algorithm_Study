package Inflearn.Advanced.Chap01;

public class Chap01_04 {
    public static int[] solution(int c, int r, int k){
        if(k > c * r) return new int[]{0, 0};

        int[] answer = new int[2];
        int[][] seat = new int[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0, x = r - 1, y = 0, count = 0;

        while(count < k){
            count++;
            seat[x][y] = count;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c || seat[nx][ny] > 0){
                direction = (direction + 1) % 4;
                if(count < 30) {
                    count--;
                }
                else break;
                continue;
            }

            x = nx;
            y = ny;
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(seat[i][j] == k){
                    answer[0] = j + 1;
                    answer[1] = i + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
