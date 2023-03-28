package Chap01;

public class Chap01_09 {
    public static int solution(String s){
        int answer = 0;
        s = s.replaceAll("[^0-9]", "");
        answer = Integer.parseInt(s, 10);
        return answer;
    }
}
