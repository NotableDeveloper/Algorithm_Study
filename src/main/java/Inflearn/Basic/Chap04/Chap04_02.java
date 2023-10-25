package Inflearn.Basic.Chap04;

import java.util.HashMap;

public class Chap04_02 {
    public static String solution(String str1, String str2){
        String answer = "YES";
        HashMap<Character, Integer> charHM = new HashMap<>();

        for(char c : str1.toCharArray()){
            if(!charHM.containsKey(c))
                charHM.put(c, 1);

            else{
                int count = charHM.get(c) + 1;
                charHM.put(c, count);
            }
        }

        for(char c : str2.toCharArray()){
            if(charHM.containsKey(c)){
                int count = charHM.get(c) - 1;
                charHM.put(c, count);
            }

            else charHM.put(c, 1);

        }

        for(int count : charHM.values()) {
            if (count > 0) return "NO";
        }

        return answer;
    }
}
