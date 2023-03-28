package Chap01;

public class Chap01_04 {
    public static String[] solution(int size, String[] input){
        String[] answer = new String[size];

        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder(input[i]);
            answer[i] = sb.reverse().toString();
        }

        return answer;
    }
}
