package Basic.Chap01;

public class Chap01_07 {
    public static String solution(String s){
        String answer = "YES";

        char[] tempStr = s.toCharArray();

        int lt = 0, rt = tempStr.length - 1;

        while(lt < tempStr.length && rt >= 0){
            if(lt == rt || rt - lt == 1) break;

            if(Character.toLowerCase(tempStr[lt]) != Character.toLowerCase(tempStr[rt])){
                return "NO";
            }

            lt++;
            rt--;
        }

        return answer;
    }
}
