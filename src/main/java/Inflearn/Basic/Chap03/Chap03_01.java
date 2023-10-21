package Inflearn.Basic.Chap03;

public class Chap03_01 {
    public static int[] solution(int n, int[] arr1, int m, int[] arr2){
        int[] answer = new int[n + m];
        int lt = 0, rt = 0, index = 0;

        while(lt < n && rt < m){
            if(arr1[lt] < arr2[rt]){
                answer[index] = arr1[lt];
                index++;
                lt++;
            }

            else{
                answer[index] = arr2[rt];
                index++;
                rt++;
            }
        }

        while(lt < n){
            answer[index] = arr1[lt];
            index++;
            lt++;
        }

        while(rt < m){
            answer[index] = arr2[rt];
            index++;
            rt++;
        }

        return answer;
    }
}
