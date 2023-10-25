package Inflearn.Advanced.Chap01;

public class Chap01_03 {
    public static int solution(int[][] board){
        int answer = 0, n = 10;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dirHyunSu = 0, dirDog = 0;
        int[] HyunSu = getLocate(board, 2);
        int[] Dog = getLocate(board, 3);

        while(answer < 10000){
            answer++;

            int nxHyunSu = HyunSu[0] + dx[dirHyunSu];
            int nyHyunSu = HyunSu[1] + dy[dirHyunSu];
            int nxDog = Dog[0] + dx[dirDog];
            int nyDog = Dog[1] + dy[dirDog];
            boolean hyunSuFlag = true, dogFlag = true;

            if(nxHyunSu < 0 || nyHyunSu >= n ||
                    nyHyunSu < 0 || nxHyunSu >= n ||
                    board[nxHyunSu][nyHyunSu] == 1){
                dirHyunSu = (dirHyunSu + 1) % 4;
                hyunSuFlag = false;
            }

            if(nxDog < 0 || nyDog >= n ||
                    nyDog < 0 || nxDog >= n ||
                    board[nxDog][nyDog] == 1){
                dirDog = (dirDog + 1) % 4;
                dogFlag = false;
            }

            if(hyunSuFlag){
                HyunSu[0] = nxHyunSu;
                HyunSu[1] = nyHyunSu;

            }

            if(dogFlag){
                Dog[0] = nxDog;
                Dog[1] = nyDog;

            }

            if(HyunSu[0] == Dog[0] && HyunSu[1] == Dog[1]) break;
        }

        if(answer >= 10000) return 0;

        return answer;
    }

    private static int[] getLocate(int[][] board, int target){
        int[] locate = new int[2];
        int n = 10;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == target){
                    locate[0] = i;
                    locate[1] = j;
                    break;
                }
            }
        }

        return locate;
    }
}
