package Other.implement;

import java.util.Arrays;

public class StringSort {
    public static String solution(String S){
        StringBuilder answer = new StringBuilder();
        int sum = 0;
        char[] sorted_str = S.toCharArray();
        Arrays.sort(sorted_str);

        for(char c : sorted_str){
            if(Character.isAlphabetic(c)) answer.append(c);
            else sum += c - '0';
        }

        answer.append(sum);

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("K1KA5CB7"));
        System.out.println(solution("AJKDLSI412K4JSJ9D"));
    }
}
