package BOJ.bruteforce;

public class BOJ7696 {
  public static void main(String[] args) {
    int n = 10; // 원하는 순번 (n을 변경하세요)

    int count = 0;
    int num = 1;

    while (count < n) {
      String numStr = Integer.toString(num);
      boolean hasRepeatingDigit = false;

      for (int i = 0; i < numStr.length() - 1; i++) {
        for (int j = i + 1; j < numStr.length(); j++) {
          if (numStr.charAt(i) == numStr.charAt(j)) {
            hasRepeatingDigit = true;
            break;
          }
        }
        if (hasRepeatingDigit) {
          break;
        }
      }

      if (!hasRepeatingDigit) {
        count++;
      }

      if (count == n) {
        System.out.println("The " + n + "th number without repeating digits is: " + num);
      }

      num++;
    }
  }
}
