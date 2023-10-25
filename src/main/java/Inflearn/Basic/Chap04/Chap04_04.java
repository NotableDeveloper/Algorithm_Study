package Inflearn.Basic.Chap04;

import java.util.HashMap;

public class Chap04_04 {
    public static int solution(String s, String t){
        int answer = 0, left = 0, length = t.length() - 1;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for(int right = length; right < s.length(); right++){
            char a = s.charAt(right);
            sMap.put(a, sMap.getOrDefault(a, 0) + 1);

            if(sMap.equals(tMap)) answer++;

            char b = s.charAt(left);
            sMap.put(b, sMap.get(b) - 1);

            if(sMap.get(b) == 0)
                sMap.remove(b);

            left++;
        }

        return answer;
    }
}
