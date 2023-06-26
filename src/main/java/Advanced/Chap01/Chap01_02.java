package Advanced.Chap01;

public class Chap01_02 {
    public static int[] solution(int[][] board, int k){
        int minute = 0, x = 0, y = 0;
        int d = 1, n = board.length;
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(minute < k){
            minute++;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
