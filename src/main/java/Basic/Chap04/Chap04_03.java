package Basic.Chap04;

import java.util.ArrayList;
import java.util.HashMap;

public class Chap04_03 {
    public static ArrayList<Integer> solution(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i = 0; i < k - 1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }

        int lt = 0;

        for(int rt = k - 1; rt < n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) - 1);

            if(HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }

        return answer;
    }
}
