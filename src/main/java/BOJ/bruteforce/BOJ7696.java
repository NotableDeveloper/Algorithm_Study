package BOJ.bruteforce;

import java.io.*;
import java.util.Arrays;

class BOJ7696 {
  static int[] dic = new int[1000001];

  public static void main(String[] args) throws IOException {
    for (int idx = 1, num = 1; idx <= 1000000; num++) {
      if (!isDistinct(num)) {
        dic[idx++] = num;
      }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) break;
      System.out.println(dic[num]);
    }
  }

  static boolean isDistinct(int num) {
    boolean[] used = new boolean[10];
    Arrays.fill(used, false);

    while (num != 0) {
      if (used[num % 10]) {
        return true;
      }
      used[num % 10] = true;
      num /= 10;
    }
    return false;
  }
}
