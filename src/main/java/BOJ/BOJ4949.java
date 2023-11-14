package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ4949 {
  public static String solution(String str) {
    Stack<Character> stack = new Stack<>();

    for (char c : str.toCharArray()) {
      if (c == '(' || c == '[') {
        stack.push(c);
      } else if (c == ')') {
        if (!stack.empty() && stack.peek() == '(') stack.pop();
        else return "no";
      } else if (c == ']') {
        if (!stack.empty() && stack.peek() == '[') stack.pop();
        else return "no";
      }
    }

    if(stack.empty()) return "yes";
    else return "no";
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> inputs = new ArrayList<>();

    while (true) {
      String input = br.readLine();

      if (input.equals(".")) break;
      else inputs.add(input);
    }

    for (String s : inputs) {
      System.out.println(solution(s));
    }
  }
}
