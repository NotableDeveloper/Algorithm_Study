package Inflearn.Basic.Chap01;

public class Chap01_06 {
    public static String solution(String s){
        StringBuilder answer = new StringBuilder();
        char[] tempStr = s.toCharArray();

        for(char c : tempStr){
            if(answer.indexOf(String.valueOf(c)) == -1){
                answer.append(c);
            }
        }

        return answer.toString();
    }
}
