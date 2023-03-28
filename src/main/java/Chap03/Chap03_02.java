package Chap03;

import java.util.ArrayList;
import java.util.Arrays;

public class Chap03_02 {
    public static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer;
        ArrayList<Integer> intersection = new ArrayList<>();
        int lt = 0, rt = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(lt < n && rt < m){
            if(arr1[lt] == arr2[rt]) {
                intersection.add(arr1[lt]);
                lt++;
                rt++;
            }

            else if(arr1[lt] < arr2[rt]){
                lt++;
            }

            else rt++;
        }

        answer = intersection.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
