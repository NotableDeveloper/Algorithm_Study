package Basic.Chap04;


import java.util.Collections;
import java.util.TreeSet;

public class Chap04_05{
    public static int solution(int[] arr, int n, int k){
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int l = j + 1; l < n; l++){
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int count = 0;

        for(int x : Tset){
            count++;

            if(count == k)
                return x;
        }

        return answer;
    }
}
