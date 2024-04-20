package Inflearn.Basic.Chap02;

import java.util.Arrays;

public class Chap02_06 {
    static boolean[] isPrime;
    private static void fillPrimeArray(int n){
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!isPrime[i]) continue;

            for(int j = i; i * j <= n; j++){
                isPrime[i * j] = false;
            }
        }
    }

    private static int reverseNumber(int number){
        int reverseNumber = 0;

        while(number > 0){
            int remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number = number / 10;
        }

        return reverseNumber;
    }

    public static void main(String[] args) {
        int[] numbers = {32, 55, 62, 20, 250, 370, 200, 30, 100};

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = reverseNumber(numbers[i]);
        }

        fillPrimeArray(Arrays.stream(numbers).max().getAsInt());

        for(int number : numbers){
            if(isPrime[number])
                System.out.print(number + " ");
        }
    }
}
