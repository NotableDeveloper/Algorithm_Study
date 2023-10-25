package Inflearn.Basic.Chap01;

public class Chap01_03 {
    public static String solution(String s){
        String answer = " ";
        String[] strList = s.split(" ");
        int maxLength = Integer.MIN_VALUE;

        for(String str : strList){
            if(str.length() > maxLength){
                maxLength = str.length();
                answer = str;
            }
        }

        return answer;
    }
}
