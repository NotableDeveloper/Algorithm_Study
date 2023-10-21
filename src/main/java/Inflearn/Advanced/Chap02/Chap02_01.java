package Inflearn.Advanced.Chap02;

import java.util.HashMap;

public class Chap02_01 {
    public static int solution(String s){
        int answer = Integer.MAX_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] str = s.toCharArray();

        for(int i = 0; i < str.length; i++){
            if(!hm.containsKey(str[i])){
                hm.put(str[i], i + 1);
            }

            else{
                hm.remove(str[i]);
            }
        }

        if(hm.isEmpty())
            answer = -1;

        else{
            for(int i : hm.values()){
                answer = Math.min(i, answer);
            }
        }

        return answer;
    }
}
