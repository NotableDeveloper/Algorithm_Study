package Inflearn.Basic.Chap02;

import java.util.ArrayList;

public class Chap02_01 {
    public static int[] solution(int length, int[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(numbers[0]);

        for(int i = 1; i < length; i++){
            if(numbers[i] > numbers[i - 1]){
                temp.add(numbers[i]);
            }
        }

        int[] answer = temp.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
