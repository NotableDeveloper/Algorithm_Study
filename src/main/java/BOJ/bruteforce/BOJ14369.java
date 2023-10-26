package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class BOJ14369_TestCase{
  int[] alpha;
  int caseNum;
  String phoneNum;
  ArrayList<Integer> answer;

  public BOJ14369_TestCase(int caseNum, String phoneNum){
    this.alpha = new int[26];
    this.caseNum = caseNum;
    this.phoneNum = phoneNum;
    this.answer = new ArrayList<>();
  }

  public void solution(){
    countAlpha();
    decoding();
  }
  public void print(){
    StringBuilder sb = new StringBuilder();
    Collections.sort(answer);
    answer.forEach((Integer num) -> sb.append(num));
    System.out.println("Case #" + caseNum + ": " + sb);
  }

  private void countAlpha(){
    Arrays.fill(this.alpha, 0);

    for(char c : this.phoneNum.toCharArray())
      alpha[c - 'A']++;
  }

  private void decoding(){
    while(true){
      if(alpha['Z' - 'A'] > 0) findAlpha("ZERO", 0);
      else if(alpha['W' - 'A'] > 0) findAlpha("TWO", 2);
      else if(alpha['U' - 'A'] > 0) findAlpha("FOUR", 4);
      else if(alpha['F' - 'A'] > 0) findAlpha("FIVE", 5);
      else if(alpha['X' - 'A'] > 0) findAlpha("SIX", 6);
      else if(alpha['V' - 'A'] > 0) findAlpha("SEVEN", 7);
      else if(alpha['G' - 'A'] > 0) findAlpha("EIGHT", 8);
      else if(alpha['O' - 'A'] > 0) findAlpha("ONE", 1);
      else if(alpha['N' - 'A'] > 0) findAlpha("NINE", 9);
      else if(alpha['H' - 'A'] > 0) findAlpha("THREE", 3);
      else break;
    }
  }

  private void findAlpha(String alphabet, int findNumber){
    for(char c : alphabet.toCharArray()){
      alpha[c - 'A']--;
    }

    answer.add(findNumber);
  }
}


public class BOJ14369 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    BOJ14369_TestCase[] testCases = new BOJ14369_TestCase[n];

    for(int i = 0; i < n; i++){
      String phoneNum = br.readLine();
      BOJ14369_TestCase testCase = new BOJ14369_TestCase((i + 1), phoneNum);
      testCases[i] = testCase;
      testCase.solution();
    }

    for(BOJ14369_TestCase testCase : testCases){
      testCase.print();
    }
  }
}
