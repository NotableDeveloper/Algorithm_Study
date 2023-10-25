package Inflearn.Advanced.Chap01;

public class Chap01_08 {
    public static int[] solution(int[] enter, int[] exit){
        int n = enter.length, count = 0;
        int[] answer = new int[n];
        int[] enterIdx = new int[n];
        int[] enterTime = new int[n];
        int[] exitTime = new int[n];

        for(int i = 0; i < n; i++){
            enterIdx[enter[i] - 1] = i;
        }

        for(int i = 0, j = 0; i < n; i++){
            while(j < n && j <= enterIdx[exit[i] - 1]){
                enterTime[enter[j] - 1] = count++;
                j++;
            }

            exitTime[exit[i] - 1] = count++;
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(!(exitTime[i] < enterTime[j] || exitTime[j] < enter[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }
}
