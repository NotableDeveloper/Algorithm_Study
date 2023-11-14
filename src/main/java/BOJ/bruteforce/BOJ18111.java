package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    https://comain.tistory.com/281
*/
public class BOJ18111 {
  static int N, M, B;
  static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
  static int[][] blocks;

  public static void solution() {
    int time = Integer.MAX_VALUE;
    int height = 0;

    /*
        최소층부터 최대층까지 블럭을 평탄화하는 시간을 구한다.
    */
    for (int i = min; i <= max; i++) {
      /*
        count : 깎거나 올려야하는 블럭의 갯수
        block : 현재 갖고있는 블럭의 갯수
      */
      int count = 0;
      int block = B;

      /*
        N행 M열에 있는 블럭을 현재 층수에 맞게 조정한다.
      */
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
            /*
                현재 블럭이 기준보다 높은 경우, 기준에 맞게
                블럭을 낮추는(= 블럭을 깨는) 행동을 한다.
            */
          if (i < blocks[j][k]) {
            count += ((blocks[j][k] - i) * 2);
            block += (blocks[j][k] - i);
          }

          /*
            현재 블럭이 기준보다 높이가 작은 경우,
            기준에 맞게 블럭을 높히는(= 블럭을 쌓는) 행동을 한다.
          */
          else {
            count += (i - blocks[j][k]);
            block -= (i - blocks[j][k]);
          }
        }
      }

      /*
        블럭을 모두 소모하여 음수가 되었다면 해당 기준 층수로는
        모든 블럭의 높이를 맞출 수 없다.
      */
      if (block < 0) break;

      /*
        기준 층을 만드는 데에 소요한 시간과 기준 층을 저장한다.
      */
      if (time >= count) {
        time = count;
        height = i;
      }
    }

    System.out.println(time + " " + height);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    N = Integer.parseInt(input[0]);
    M = Integer.parseInt(input[1]);
    B = Integer.parseInt(input[2]);
    blocks = new int[N][M];

    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        blocks[i][j] = Integer.parseInt(input[j]);

        if (min > blocks[i][j]) min = blocks[i][j];
        if (max < blocks[i][j]) max = blocks[i][j];
      }
    }

    solution();
  }
}
