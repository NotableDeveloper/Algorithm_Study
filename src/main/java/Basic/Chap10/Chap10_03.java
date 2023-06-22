package Basic.Chap10;

public class Chap10_03 {
    /*
        인덱스가 가리키는 값을 수열의 마지막 항이라 가정할 때,
        해당 수열의 길이를 나타냄.

        Ex) 입력 값이 5 3 7 8 6 2 9 4 이면
        DP[3]은 8을 마지막 항으로 했을 때 생겨날 수 있는 수열의 최대 길이를 저장.
     */
    static int[] DP;

    public static int solution(int n, int[] arr){
        int answer = 0;
        DP = new int[n];
        DP[0] = 1;

        // 0번째 인덱스부터 n번째 인덱스까지 순차적으로 탐색
        for(int i = 1; i < n; i++){
            int max = 0;

            // 현재 인덱스보다 앞에 있는 인덱스들을 탐색
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i] && DP[j] > max) max = DP[j];
            }

            DP[i] = max + 1;
            answer = Math.max(answer, DP[i]);
        }

        return answer;
    }
}

