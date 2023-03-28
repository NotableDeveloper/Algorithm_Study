package Chap01;

public class Chap01_12 {
    public static String solution(int n, String s){
        String answer = "";

        for(int i = 0; i < n; i++){
            String temp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            answer += (char) num;
            s = s.substring(7);
        }

        return answer;
    }
}
