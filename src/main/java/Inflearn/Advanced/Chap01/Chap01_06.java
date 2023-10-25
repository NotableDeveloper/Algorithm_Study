package Inflearn.Advanced.Chap01;

public class Chap01_06 {
    private static int getMin(int[] fruit){
        int min = Integer.MAX_VALUE;

        for(int f : fruit){
            min = Math.min(min, f);
        }

        return min;
    }

    private static boolean isMinUnique(int[] fruit){
        int count = 0;
        int min = getMin(fruit);

        for(int f : fruit){
            if(f == min)
                count++;
        }

        return count == 1;
    }

    private static int getMinIndex(int[] fruit){
        int min = getMin(fruit);

        for(int i = 0; i < 3; i++){
            if(fruit[i] == min)
                return i;
        }

        return 0;
    }

    public static int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for(int i = 0; i < n; i++){
            if(ch[i] == 1) continue;
            if(isMinUnique(fruit[i]) == false) continue;
            for(int j = i+1; j < n; j++){
                if(ch[j] == 1) continue;
                if(isMinUnique(fruit[j]) == false) continue;
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0){
                    if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1){
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer += getMin(x);
        }
        return answer;
    }
}
