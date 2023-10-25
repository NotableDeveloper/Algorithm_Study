package Inflearn.Basic.Chap01;

public class Chap01_02 {
    public static String solution(String s){
        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                answer.append(Character.toUpperCase(c));
            }

            else{
                answer.append(Character.toLowerCase(c));
            }
        }

        return answer.toString();
    }

    public static String solution2(String s) {
        StringBuilder answer = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c >= 65 && c <= 90){
                char temp = (char) (c + 32);
                answer.append(temp);
            }

            else{
                char temp = (char) (c - 32);
                answer.append(temp);
            }
        }

        return answer.toString();
    }
}
