package Basic.Chap01;

public class Chap01_11 {
    public static String solution(String s){
        String answer = "";
        s = s + " ";
        int count = 1;

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) count++;

            else{
                answer += s.charAt(i);
                if(count > 1) answer += String.valueOf(count);
                count = 1;
            }
        }

        return answer;
    }
}
