package Basic.Chap01;

public class Chap01_05 {
    public static String solution(String s){
        StringBuilder answer = new StringBuilder();
        char[] tempStr = s.toCharArray();
        int lt = 0, rt = tempStr.length - 1;

        while(lt < tempStr.length && rt >= 0){
            if(Character.isAlphabetic(tempStr[lt]) && Character.isAlphabetic(tempStr[rt])){
                char temp = tempStr[lt];
                tempStr[lt] = tempStr[rt];
                tempStr[rt] = temp;
            }

            if(lt == rt || rt - lt == 1) {
                break;
            }

            lt++;
            rt--;

        }

        for(char c : tempStr){
            answer.append(c);
        }

        return answer.toString();
    }
}
