package Inflearn.Basic.Chap04;

import java.util.HashMap;

public class Chap04_01 {
    public static char solution(String candidate){
        char answer = ' ';
        int max = 0;

        HashMap<Character, Integer> vote = new HashMap<>();

        for(char c : candidate.toCharArray()){
            if(!vote.containsKey(c))
                vote.put(c, 1);

            else{
                int count = vote.get(c) + 1;
                vote.put(c, count);
            }
        }

        for(char student : vote.keySet()){
            int count = vote.get(student);

            if(max < count) {
                answer = student;
                max = count;
            }
        }

        return answer;
    }
}
