import java.io.*;
import java.util.Arrays;

class Main {
  static int[] dic = new int[1000001];
  static boolean[] used = new boolean[10];

  public static void main(String[] args) throws IOException {
    init();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0)
        break;
      System.out.println(dic[num]);
    }
  }

  static void init() {
    for (int idx = 1, num = 1; idx <= 1000000; num++) {
      if (!isDistinct(num)) {
        dic[idx++] = num;
      }
    }
  }

  static boolean isDistinct(int num) {
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