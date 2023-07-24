package Advanced.Chap01;

public class Chap01_07 {
    /*
        상, 하, 좌, 우, 좌상, 우상, 좌하, 우하 순서로 탐색
     */
    private final static int[] X = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final static int[] Y = {0, 0, -1, 1, -1, 1, -1, 1};

    public static int solution(int[] keypad, String password){
        int answer = 0, x = 0, y = 0;
        int[][] map = setMap(keypad);
        char[] pw = password.toCharArray();
        boolean find = false;

        /*
            가장 처음에 누를 키의 위치를 구함
         */
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(map[i][j] == Character.digit(pw[0], 10)){
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        /*
            비밀번호를 하나씩 순차적으로 탐색
         */
        for(int i = 1; i < pw.length; i++){
            int number = Character.digit(pw[i], 10);

            /*
                현재 위치가 눌러야할 번호이면 다음 번호를 보고,
                아니라면 인근 위치를 탐색
             */
            if(map[x][y] == number) continue;

            else find = false;

            /*
                상, 하, 좌, 우, 좌상, 우상, 좌하, 우하 순서대로 현재 눌러야하는
                번호가 있는 지를 확인.
             */
            for(int next = 0; next < 8; next++){
                int nx = x + X[next];
                int ny = y + Y[next];

                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3 && map[nx][ny] == number){
                    x = nx;
                    y = ny;
                    find = true;
                    break;
                }
            }

            /*
                현재 위치에서 1칸 이내로 번호를 누를 수 있으면 1초 증가
             */
            if(find){
                answer++;
            }

            /*
                현재 위치에서 1칸 이내로 번호를 누를 수 없으면 2초 증가
                이후, 다음에 누를 번호의 시작 위치를 찾음
             */
            else {
                answer += 2;
                int nextNumber = Character.digit(pw[i], 10);
                int[] replaceXY = replace(map, nextNumber);
                x = replaceXY[0];
                y = replaceXY[1];
            }
        }

        return answer;
    }

    /*
        1차원 비밀번호를 2차원 비밀번호 형태로 초기화
     */
    static private int[][] setMap(int[] keypad){
        int x = 0, y = 0;
        int[][] map = new int[3][3];

        for(int i : keypad){
            map[x][y] = i;

            if((y != 0) && ((y + 1) % 3 == 0)){
                x++;
                y = 0;
            }

            else y++;
        }

        return map;
    }

    /*
        1칸 이내로 누를 수 없는 키를 발견했을 때, 다음 키의 위치를 구함.
     */
    static private int[] replace(int[][] map, int number){
        int[] XY = new int[2];

        for(int nx = 0; nx < 3; nx++){
            for(int ny = 0; ny < 3; ny++){
                if(map[nx][ny] == number){
                    XY[0] = nx;
                    XY[1] = ny;
                }
            }
        }

        return XY;
    }
}
